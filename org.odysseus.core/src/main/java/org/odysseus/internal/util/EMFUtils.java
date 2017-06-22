package org.odysseus.internal.util;

import static com.google.common.base.Preconditions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.odysseus.exceptions.EPackagesAreNotSelfContainedException;
import org.odysseus.exceptions.XMIConversionFailedException;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class EMFUtils {

	/**
	 * Factory method: Instantiates a new default {@link ResourceSet}.
	 *
	 * <p>
	 * The new resource set will always have the XMI factory associated with the "*.xmi" file ending.
	 *
	 * @return The new resource set. Never <code>null</code>.
	 */
	public static ResourceSet createResourceSet() {
		return createResourceSet(Collections.emptySet());
	}

	/**
	 * Factory method: Instantiates a new default {@link ResourceSet}.
	 *
	 * <p>
	 * The new resource set will always have the XMI factory associated with the "*.xmi" file ending.
	 *
	 * @param ePackages
	 *            The {@link EPackage}s to register at the resource set. Must not be <code>null</code>.
	 *
	 * @return The new resource set. Never <code>null</code>.
	 */
	public static ResourceSet createResourceSet(final Set<EPackage> ePackages) {
		checkNotNull(ePackages, "Precondition violation - argument 'ePackages' must not be NULL!");
		ResourceSet resSet = new ResourceSetImpl();
		// make sure that XMI is available
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		for (EPackage ePackage : ePackages) {
			resSet.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
		}
		return resSet;
	}

	/**
	 * Creates a temporary resource.<br>
	 * The resource will be contained in a (new) temporary resource set. It is important <b>not</b> to save this
	 * resource to disk!
	 *
	 * @param name
	 *            The name of the resource (implementation will be selected based on ending)
	 * @param contents
	 *            The contents to put into the new temporary resource
	 * @return The resource with the given contents and name
	 */
	public static Resource createTemporaryResource(final String name, final EObject... contents) {
		return createTemporaryResource(name, Collections.emptySet(), contents);
	}

	/**
	 * Creates a temporary resource.<br>
	 * The resource will be contained in a (new) temporary resource set. It is important <b>not</b> to save this
	 * resource to disk!
	 *
	 * @param name
	 *            The name of the resource (implementation will be selected based on ending)
	 * @param ePackages
	 *            The {@link EPackage}s to register at the temporary {@link ResourceSet}. Must not be <code>null</code>.
	 * @param contents
	 *            The contents to put into the new temporary resource
	 * @return The resource with the given contents and name
	 */
	public static Resource createTemporaryResource(final String name, final Set<EPackage> ePackages,
			final EObject... contents) {
		checkNotNull(name, "Precondition violation - argument 'name' must not be NULL!");
		checkNotNull(ePackages, "Precondition violation - argument 'ePackages' must not be NULL!");
		ResourceSet resSet = createResourceSet(ePackages);
		return createTemporaryResource(resSet, name, contents);
	}

	/**
	 * Creates a temporary resource.<br>
	 * It is important <b>not</b> to save this resource to disk!
	 *
	 * @param set
	 *            The {@link ResourceSet} to put this resource into
	 * @param name
	 *            The name of the resource (implementation will be selected based on ending)
	 * @param contents
	 *            The contents to put into the new temporary resource
	 * @return The resource with the given contents and name
	 */
	public static Resource createTemporaryResource(final ResourceSet set, final String name,
			final EObject... contents) {
		Resource res = set.createResource(URI.createPlatformResourceURI("TEMP/" + name, false));
		for (EObject obj : contents) {
			res.getContents().add(obj);
		}
		return res;
	}

	/**
	 * Writes the given {@link EPackage} to XMI.
	 *
	 * @param ePackage
	 *            The EPackage to convert to XMI. Must not be <code>null</code>.
	 * @return The XMI representation of the EPackage. Never <code>null</code>.
	 */
	public static String writeEPackageToXMI(final EPackage ePackage) {
		checkNotNull(ePackage, "Precondition violation - argument 'ePackage' must not be NULL!");
		return writeEPackagesToXMI(Collections.singleton(ePackage));
	}

	/**
	 * Writes the given {@link EPackage}s to XMI.
	 *
	 * @param ePackages
	 *            The EPackages to convert to XMI. Must not be <code>null</code>.
	 * @return The XMI representation of the EPackages. Never <code>null</code>.
	 */
	public static String writeEPackagesToXMI(final Iterable<? extends EPackage> ePackages) {
		checkNotNull(ePackages, "Precondition violation - argument 'ePackages' must not be NULL!");
		try {
			return writeEObjectsToXMI(ePackages);
		} catch (XMIConversionFailedException e) {
			throw new XMIConversionFailedException("Could not convert EPackages to XMI!", e);
		}
	}

	/**
	 * Reads the given XMI contents and converts them into an {@link EPackage}.
	 *
	 * <p>
	 * It is the responsibility of the caller to assert that there is exactly one {@link EObject} in the given XMI data,
	 * and that this object is an instance of {@link EPackage}.
	 *
	 * @param xmiContents
	 *            The XMI data that contains the EPackage to deserialize. Must not be <code>null</code>.
	 * @return The EPackage that was contained in the given XMI data. May be <code>null</code> if the XMI data was
	 *         empty.
	 */
	public static EPackage readEPackageFromXMI(final String xmiContents) {
		checkNotNull(xmiContents, "Precondition violation - argument 'xmiContents' must not be NULL!");
		try {
			List<EObject> eObjects = readEObjectsFromXMI(xmiContents);
			if (eObjects == null || eObjects.isEmpty()) {
				return null;
			}
			EObject singleObject = Iterables.getOnlyElement(eObjects);
			if (singleObject instanceof EPackage == false) {
				throw new IllegalStateException(
						"Attempted to read EPackage from XMI, but encountered EObject with EClass '"
								+ singleObject.eClass().getName() + "'!");
			}
			return (EPackage) singleObject;
		} catch (XMIConversionFailedException e) {
			throw new XMIConversionFailedException("Could not read EPackage from XMI data!", e);
		}
	}

	public static List<EPackage> readEPackagesFromXMI(final String xmiContents) {
		checkNotNull(xmiContents, "Precondition violation - argument 'xmiContents' must not be NULL!");
		try {
			List<EObject> eObjects = readEObjectsFromXMI(xmiContents);
			if (eObjects == null || eObjects.isEmpty()) {
				return null;
			}
			List<EPackage> ePackages = Lists.newArrayList();
			eObjects.forEach(eObject -> {
				if (eObject instanceof EPackage == false) {
					throw new IllegalStateException(
							"Attempted to read EPackage from XMI, but encountered EObject with EClass '"
									+ eObject.eClass().getName() + "'!");
				}
				ePackages.add((EPackage) eObject);
			});
			return ePackages;
		} catch (XMIConversionFailedException e) {
			throw new XMIConversionFailedException("Could not read EPackage from XMI data!", e);
		}
	}

	/**
	 * Writes the given {@link EObject} into its XMI representation.
	 *
	 * @param eObject
	 *            The EObject to convert to XMI. Must not be <code>null</code>.
	 * @return The XMI representation of the given EObject. Never <code>null</code>.
	 */
	public static String writeEObjectToXMI(final EObject eObject) {
		checkNotNull(eObject, "Precondition violation - argument 'eObject' must not be NULL!");
		return writeEObjectsToXMI(Collections.singleton(eObject));
	}

	/**
	 * Writse the given (@link EObject}s into their XMI representation.
	 *
	 * @param eObjects
	 *            The EObjects to convert to XMI. Must not be <code>null</code>.
	 * @return The XMI representation of the given EObjects. Never <code>null</code>.
	 */
	public static String writeEObjectsToXMI(final Iterable<? extends EObject> eObjects) {
		checkNotNull(eObjects, "Precondition violation - argument 'eObjects' must not be NULL!");
		EObject[] eObjectArray = Iterables.toArray(eObjects, EObject.class);
		Resource resource = createTemporaryResource("temp.xmi", eObjectArray);
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			resource.save(baos, null);
			String xmi = baos.toString();
			return xmi;
		} catch (IOException ioe) {
			throw new XMIConversionFailedException("Could not convert EObject to XMI!", ioe);
		}
	}

	/**
	 * Reads the {@link EObject}s contained in the given XMI data.
	 *
	 * @param xmiContents
	 *            The XMI data to deserialize the EObjects from. Must not be <code>null</code>.
	 * @return The list of deserialized EObjects. May be empty, but never <code>null</code>.
	 */
	public static List<EObject> readEObjectsFromXMI(final String xmiContents) {
		checkNotNull(xmiContents, "Precondition violation - argument 'xmiContents' must not be NULL!");
		return readEObjectsFromXMI(xmiContents, Collections.emptySet());
	}

	/**
	 * Reads the {@link EObject}s contained in the given XMI data.
	 *
	 * @param xmiContents
	 *            The XMI data to deserialize the EObjects from. Must not be <code>null</code>.
	 * @param ePackages
	 *            The {@link EPackage}s to use for reading the XMI contents. Must not be <code>null</code>.
	 *
	 * @return The list of deserialized EObjects. May be empty, but never <code>null</code>.
	 */
	public static List<EObject> readEObjectsFromXMI(final String xmiContents, final Set<EPackage> ePackages) {
		checkNotNull(xmiContents, "Precondition violation - argument 'xmiContents' must not be NULL!");
		checkNotNull(ePackages, "Precondition violation - argument 'ePackages' must not be NULL!");
		Resource resource = createTemporaryResource("temp.xmi", ePackages);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(xmiContents.getBytes())) {
			resource.load(bais, null);
			return resource.getContents();
		} catch (IOException ioe) {
			throw new XMIConversionFailedException("Could not read EObject(s) from XMI data!", ioe);
		}
	}

	/**
	 * Checks that the given {@link File} is an XMI file.
	 *
	 * @param file
	 *            The file to check. Must not be <code>null</code>.
	 *
	 * @return <code>true</code> if the given file is an XMI file, otherwise <code>false</code>.
	 *
	 * @see #assertIsXMIFile(File)
	 */
	public static boolean isXMIFile(final File file) {
		if (file == null) {
			return false;
		}
		if (file.exists() == false) {
			return false;
		}
		if (file.isFile() == false) {
			return false;
		}
		if (file.getName().endsWith(".xmi") == false) {
			return false;
		}
		return true;
	}

	/**
	 * Asserts that the given file is a valid, existing XMI file.
	 *
	 * @param file
	 *            The file to check. Must not be <code>null</code>.
	 *
	 * @throws IllegalArgumentException
	 *             Thrown if there are some irregularities with the given XMI file. The description of the exception
	 *             provides details.
	 */
	public static void assertIsXMIFile(final File file) {
		checkNotNull(file, "Precondition violation - argument 'file' must not be NULL!");
		checkArgument(file.exists(), "Precondition violation - the given XMI File does not exist!");
		checkArgument(file.isFile(), "Precondition violation - the given XMI File is a directory, not a file!");
		checkArgument(file.getName().endsWith(".xmi"),
				"Precondition violation - the given file does not end with '*.xmi'!");
	}

	/**
	 * A specialized version of {@link EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature) eGet(...)} that works for
	 * multiplicity-many {@link EReference}s only.
	 *
	 * @param eObject
	 *            The eObject to run the operation on. Must not be <code>null</code>.
	 * @param eReference
	 *            The EReference to retrieve the targets for. Must not be <code>null</code>, must be multiplicity-many.
	 * @return The EObject-backed list of targets. May be empty, but never <code>null</code>.
	 */
	public static EList<EObject> eGetMany(final EObject eObject, final EReference eReference) {
		checkNotNull(eObject, "Precondition violation - argument 'eObject' must not be NULL!");
		checkNotNull(eReference, "Precondition violation - argument 'eReference' must not be NULL!");
		checkArgument(eReference.isMany(), "Precondition violation - argument 'eReference' must be multiplicity-many!");
		@SuppressWarnings("unchecked")
		EList<EObject> list = (EList<EObject>) eObject.eGet(eReference);
		return list;
	}

	/**
	 * Given a collection of {@link EPackage}s, this method returns all {@link EReference}s with
	 * {@link EReference#getEReferenceType() target types} that are not contained in any of the given EPackages,
	 * E-Sub-Packages, or the Ecore EPackage.
	 *
	 * @param ePackages
	 *            The EPackages to check (recursively). Must not be <code>null</code>, may be empty.
	 * @return The set of {@link EReference}s that have target types outside the given EPackages (and also outside the
	 *         Ecore EPackage). Never <code>null</code>, may be empty.
	 *
	 * @see #areEPackagesSelfContained(Iterable)
	 * @see #assertEPackagesAreSelfContained(Iterable)
	 */
	public static Set<EReference> getEReferencesWithNonContainedEReferenceTypes(
			final Iterable<? extends EPackage> ePackages) {
		checkNotNull(ePackages, "Precondition violation - argument 'ePackages' must not be NULL!");
		// flatten the EPackage hierarchy
		Set<EPackage> allEPackages = flattenEPackages(ePackages);
		// all elements from the Ecore EPackage are also okay, even if they are not contained in the set above
		Set<EPackage> containedEPackages = Sets.newHashSet(allEPackages);
		containedEPackages.addAll(flattenEPackage(EcorePackage.eINSTANCE));
		// prepare the result set
		Set<EReference> resultSet = Sets.newHashSet();
		// for each ePackage, iterate over all EClasses, and find all EReferences with a target type that is NOT
		// contained in any known epackage
		for (EPackage ePackage : allEPackages) {
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass == false) {
					// ignore non-eclasses
					continue;
				}
				EClass eClass = (EClass) eClassifier;
				for (EReference eReference : eClass.getEAllReferences()) {
					EClass eReferenceType = eReference.getEReferenceType();
					EPackage owningEPackage = eReferenceType.getEPackage();
					if (containedEPackages.contains(owningEPackage) == false) {
						resultSet.add(eReference);
					}
				}
			}
		}
		return resultSet;
	}

	/**
	 * Asserts that the given collection of {@link EPackage}s is self-contained, i.e. does not reference any
	 * {@link EClass}es that reside outside the given collection of EPackages (and also outside of the
	 * {@link EcorePackage} ).
	 *
	 * @param ePackages
	 *            The {@link EPackage}s to check. Must not be <code>null</code>. May be empty.
	 * @return <code>true</code> if the given collection of {@link EPackage}s is self-contained, otherwise
	 *         <code>false</code>.
	 *
	 * @see #getEReferencesWithNonContainedEReferenceTypes(Iterable)
	 * @see #assertEPackagesAreSelfContained(Iterable)
	 */
	public static boolean areEPackagesSelfContained(final Iterable<? extends EPackage> ePackages) {
		checkNotNull(ePackages, "Precondition violation - argument 'ePackages' must not be NULL!");
		Set<EReference> nonContainedReferences = getEReferencesWithNonContainedEReferenceTypes(ePackages);
		if (nonContainedReferences.isEmpty() == false) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Asserts that the given collection of {@link EPackage}s is self-contained, i.e. does not reference any
	 * {@link EClass}es that reside outside the given collection of EPackages (and also outside of the
	 * {@link EcorePackage} ).
	 *
	 * @param ePackages
	 *            The {@link EPackage}s to check. Must not be <code>null</code>. May be empty.
	 * @throws EPackagesAreNotSelfContainedException
	 *             Thrown if there is at least one {@link EReference} in the given EPackages that points to an EClass
	 *             that is not (recursively) contained in the given EPackages.
	 *
	 * @see #getEReferencesWithNonContainedEReferenceTypes(Iterable)
	 * @see #areEPackagesSelfContained(Iterable)
	 */
	public static void assertEPackagesAreSelfContained(final Iterable<? extends EPackage> ePackages)
			throws EPackagesAreNotSelfContainedException {
		checkNotNull(ePackages, "Precondition violation - argument 'ePackages' must not be NULL!");
		Set<EReference> nonContainedReferences = getEReferencesWithNonContainedEReferenceTypes(ePackages);
		if (nonContainedReferences.isEmpty()) {
			return;
		}
		throw new EPackagesAreNotSelfContainedException(nonContainedReferences);
	}

	/**
	 * "Flattens" the given {@link EPackage} by iterating recursively over its sub-packages and throwing all encountered
	 * packages into a set.
	 *
	 * @param ePackage
	 *            The EPackage to flatten. Must not be <code>null</code>.
	 * @return A set containing the given EPackage, plus all of its sub-EPackages (recursively). Never <code>null</code>
	 *         , never empty.
	 */
	public static Set<EPackage> flattenEPackage(final EPackage ePackage) {
		checkNotNull(ePackage, "Precondition violation - argument 'ePackage' must not be NULL!");
		return flattenEPackages(Collections.singleton(ePackage));
	}

	/**
	 * "Flattens" the given collection of {@link EPackage}s by iterating recursively over their sub-packages and
	 * throwing all encountered packages into a set.
	 *
	 * @param ePackages
	 *            The EPackages to flatten. Must not be <code>null</code>. May be empty.
	 * @return A set containing the given EPackage, plus all of its sub-EPackages (recursively). Never <code>null</code>
	 *         , may be empty.
	 */
	public static Set<EPackage> flattenEPackages(final Iterable<? extends EPackage> ePackages) {
		checkNotNull(ePackages, "Precondition violation - argument 'ePackages' must not be NULL!");
		Set<EPackage> flattenedEPackages = Sets.newHashSet();
		for (EPackage rootEPackage : ePackages) {
			flattenedEPackages.add(rootEPackage);
			TreeIterator<EObject> eAllContents = rootEPackage.eAllContents();
			eAllContents.forEachRemaining(eObject -> {
				if (eObject instanceof EPackage) {
					flattenedEPackages.add((EPackage) eObject);
				}
			});
		}
		return flattenedEPackages;
	}

	public static String fullyQualifiedNameFor(final EStructuralFeature feature) {
		checkNotNull(feature, "Precondition violation - argument 'feature' must not be NULL!");
		String eClassName = fullyQualifiedNameFor(feature.getEContainingClass());
		if (feature instanceof EAttribute) {
			return eClassName + "#A(" + feature.getName() + ")";
		} else {
			return eClassName + "#R(" + feature.getName() + ")";
		}
	}

	public static String fullyQualifiedNameFor(final EClass eClass) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		String ePackageQualifiedName = fullyQualifiedNameFor(eClass.getEPackage());
		return ePackageQualifiedName + "::" + eClass.getName();
	}

	public static String fullyQualifiedNameFor(final EPackage ePackage) {
		List<String> qualifierChain = Lists.newArrayList();
		EPackage currentEPackage = ePackage;
		while (currentEPackage != null) {
			qualifierChain.add(currentEPackage.getName());
			currentEPackage = currentEPackage.getESuperPackage();
		}
		List<String> qualifiedNameParts = Lists.reverse(qualifierChain);
		StringBuilder builder = new StringBuilder();
		String separator = "";
		for (String namePart : qualifiedNameParts) {
			builder.append(separator);
			separator = ".";
			builder.append(namePart);
		}
		return builder.toString();
	}
}
