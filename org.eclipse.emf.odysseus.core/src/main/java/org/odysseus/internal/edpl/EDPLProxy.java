package org.odysseus.internal.edpl;

import static com.google.common.base.Preconditions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.odysseus.exceptions.AmbiguousFeatureException;
import org.odysseus.exceptions.FeatureNotFoundException;
import org.odysseus.exceptions.FeatureResolutionException;
import org.odysseus.exceptions.UnknownEnumLiteralException;
import org.odysseus.internal.OdysseusEPackageRegistry;
import org.odysseus.internal.configuration.FeatureAccessMode;
import org.odysseus.internal.edpl.collection.AbstractEDPLCollection;
import org.odysseus.internal.edpl.collection.EDPLEList;
import org.odysseus.internal.edpl.collection.EDPLList;
import org.odysseus.internal.edpl.collection.EDPLSet;
import org.odysseus.internal.util.ProxyUtils;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.reflect.AbstractInvocationHandler;

public class EDPLProxy extends AbstractInvocationHandler {

	// =================================================================================================================
	// STATIC FACTORY METHODS
	// =================================================================================================================

	public static <T extends EObject> T createReflective(final EObject original, final Class<T> theInterface) {
		return create(original, theInterface, FeatureAccessMode.VIA_REFLECTIVE_API);
	}

	public static <T extends EObject> T createGenerated(final EObject original, final Class<T> theInterface) {
		return create(original, theInterface, FeatureAccessMode.VIA_GENERATED_GETTERS_AND_SETTERS);
	}

	@SuppressWarnings("unchecked")
	public static <T extends EObject> T create(final EObject original, final Class<T> theInterface,
			final FeatureAccessMode featureAccessMode) {
		checkNotNull(original, "Precondition violation - argument 'original' must not be NULL!");
		checkNotNull(theInterface, "Precondition violation - argument 'clazz' must not be NULL!");
		checkArgument(theInterface.isInterface(), "Precondition violation - argument 'clazz' must be an Interface!");
		checkNotNull(featureAccessMode, "Precondition violation - argument 'featureAccessMode' must not be NULL!");
		if (ProxyUtils.isProxy(original)) {
			if (theInterface.isInstance(original) == false) {
				throw new IllegalStateException(
						"Proxy does not implement target interface '" + theInterface.getName() + "'!");
			} else {
				return (T) original;
			}
		} else {
			return ProxyUtils.createProxy(new EDPLProxy(original, featureAccessMode), theInterface);
		}
	}

	@SuppressWarnings("unchecked")
	public static <C extends Collection<T>, T extends EObject> C createCollection(final C original,
			final Class<T> theInterface, final FeatureAccessMode featureAccessMode) {
		checkNotNull(original, "Precondition violation - argument 'original' must not be NULL!");
		checkNotNull(theInterface, "Precondition violation - argument 'theInterface' must not be NULL!");
		checkArgument(theInterface.isInterface(), "Precondition violation - argument 'clazz' must be an Interface!");
		checkNotNull(featureAccessMode, "Precondition violation - argument 'featureAccessMode' must not be NULL!");
		if (original instanceof AbstractEDPLCollection) {
			return original;
		} else {
			if (original instanceof EList) {
				EList<T> originalList = (EList<T>) original;
				return (C) new EDPLEList<T>(originalList, theInterface, featureAccessMode);
			} else if (original instanceof List) {
				List<T> originalList = (List<T>) original;
				return (C) new EDPLList<T>(originalList, theInterface, featureAccessMode);
			} else if (original instanceof Set) {
				Set<T> originalSet = (Set<T>) original;
				return (C) new EDPLSet<T>(originalSet, theInterface, featureAccessMode);
			} else {
				throw new IllegalStateException(
						"Encountered unknown feature value collection class: '" + original.getClass().getName() + "'!");
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T unwrap(final T maybeProxy) {
		if (maybeProxy == null) {
			return null;
		}
		if (ProxyUtils.isProxy(maybeProxy) == false) {
			return maybeProxy;
		}
		EDPLProxy edplProxy = (EDPLProxy) ProxyUtils.getInvocationHandler(maybeProxy);
		return (T) edplProxy.getWrappedEObject();
	}

	public static boolean equalsModuloProxy(final EObject obj1, final EObject obj2) {
		if (obj1 == obj2) {
			return true;
		}
		if (obj1 == null && obj2 == null) {
			return true;
		} else if (obj1 != null && obj2 == null) {
			return false;
		} else if (obj1 == null && obj2 != null) {
			return false;
		}
		if (ProxyUtils.isProxy(obj1) == false && ProxyUtils.isProxy(obj2) == false) {
			return obj1.equals(obj2);
		}
		EObject eObject1 = EDPLProxy.unwrap(obj1);
		EObject eObject2 = EDPLProxy.unwrap(obj2);
		return eObject1.equals(eObject2);
	}

	public static EDPLProxy get(final EObject proxiedEObject) {
		checkNotNull(proxiedEObject, "Precondition violation - argument 'proxiedEObject' must not be NULL!");
		checkArgument(isEDPLProxy(proxiedEObject),
				"Precondition violation - argument 'proxiedEObject' is not an EDPL Proxy!");
		return (EDPLProxy) ProxyUtils.getInvocationHandler(proxiedEObject);
	}

	public static boolean isEDPLProxy(final EObject maybeProxy) {
		if (maybeProxy == null) {
			return false;
		}
		if (ProxyUtils.isProxy(maybeProxy) == false) {
			return false;
		}
		return ProxyUtils.getInvocationHandler(maybeProxy) instanceof EDPLProxy;
	}

	@SuppressWarnings("unchecked")
	public static Class<? extends EObject> getPrimaryJavaInterfaceForEClass(final EClass eClass) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		EClass ec = OdysseusEPackageRegistry.eINSTANCE.getCorrespondingRegisteredEClass(eClass);
		Class<? extends EObject> instanceClass = (Class<? extends EObject>) ec.getInstanceClass();
		if (instanceClass.isInterface()) {
			return instanceClass;
		}
		if (instanceClass.getName().endsWith("Impl")) {
			for (Class<?> interf : instanceClass.getInterfaces()) {
				if ((interf.getName() + "Impl").equals(instanceClass.getName())) {
					return (Class<? extends EObject>) interf;
				}
			}
		}
		throw new IllegalStateException(
				"Could not determine the Java Interface for EClass '" + eClass.getName() + "'!");
	}

	// =================================================================================================================
	// FIELDS
	// =================================================================================================================

	private final EObject eObject;
	private final FeatureAccessMode featureAccessMode;

	// =================================================================================================================
	// CONSTRUCTOR
	// =================================================================================================================

	protected EDPLProxy(final EObject eObject, final FeatureAccessMode featureAccessMode) {
		checkNotNull(eObject, "Precondition violation - argument 'eObject' must not be NULL!");
		this.eObject = eObject;
		this.featureAccessMode = featureAccessMode;
	}

	// =================================================================================================================
	// INVOCATION HANDLER
	// =================================================================================================================

	@Override
	public Object handleInvocation(final Object proxy, final Method method, final Object[] args) throws Throwable {
		if (this.isEObjectFeatureAccessor(method) == false) {
			// it's not a feature accessor; redirect to the internal EObject
			return method.invoke(this.eObject, args);
		} else {
			// it's a feature accessor. How we access the feature is up to our configuration
			return this.accessFeature(method, args);
		}
	}

	// =================================================================================================================
	// HASH CODE, EQUALS, TOSTRING
	// =================================================================================================================

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this.eObject == null ? 0 : this.eObject.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		EDPLProxy other = (EDPLProxy) obj;
		if (this.eObject == null) {
			if (other.eObject != null) {
				return false;
			}
		} else if (!this.eObject.equals(other.eObject)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ProxyOf[" + this.eObject.toString() + "]";
	}

	// =================================================================================================================
	// PROXY API
	// =================================================================================================================

	public EObject getWrappedEObject() {
		return this.eObject;
	}

	public FeatureAccessMode getFeatureAccessMode() {
		return this.featureAccessMode;
	}

	// =================================================================================================================
	// FEATURE ACCESS METHODS
	// =================================================================================================================

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Object accessFeature(final Method method, final Object[] args) {
		checkNotNull(method, "Precondition violation - argument 'method' must not be NULL!");
		checkNotNull(args, "Precondition violation - argument 'args' must not be NULL!");
		EStructuralFeature feature = this.getFeatureForAccessorMethod(method);
		if (this.isEObjectFeatureSetter(method)) {
			if (args.length != 1) {
				throw new IllegalStateException("Encountered more than one argument on Feature setter: " + method);
			}
			Object newValue = args[0];
			if (feature instanceof EReference) {
				// the contained value is an EObject or a collection of EObject(s), we need
				// to unwrap the proxies first
				if (feature.isMany()) {
					Collection currentValues = (Collection) this.getFeatureValueInternal(method, feature);
					currentValues.clear();
					Collection newValues = (Collection) newValue;
					for (Object element : newValues) {
						if (element instanceof EObject) {
							EObject eObject = (EObject) newValue;
							EObject realEObject = unwrap(eObject);
							currentValues.add(realEObject);
						} else {
							// an EReference to something that isn't an EObject is technically allowed,
							// but rarely used in practice...
							currentValues.add(element);
						}
					}
				} else {
					if (newValue instanceof EObject) {
						EObject eObject = (EObject) newValue;
						EObject realEObject = unwrap(eObject);
						this.setFeatureValueInternal(method, feature, realEObject);
					} else {
						// an EReference to something that isn't an EObject is technically allowed,
						// but rarely used in practice...
						this.setFeatureValueInternal(method, feature, newValue);
					}
				}
			} else {
				// the contained value is a primitive or a collection of primitives, no need
				// to do proxy unwrapping
				this.eObject.eSet(feature, args[0]);
			}
			// setters don't have return values in Ecore
			return null;
		} else if (this.isEObjectFeatureGetter(method)) {
			if (feature instanceof EReference) {
				EReference eReference = (EReference) feature;
				Class refTargetType = this.getReferenceInterfaceType(eReference);
				if (feature.isMany()) {
					Collection innerCollection = (Collection) this.getFeatureValueInternal(method, feature);
					return createCollection(innerCollection, refTargetType, this.featureAccessMode);
				} else {
					Object value = this.getFeatureValueInternal(method, feature);
					if (value == null) {
						return null;
					}
					if (value instanceof EObject) {
						EObject eObject = (EObject) value;
						return EDPLProxy.create(eObject, refTargetType, this.featureAccessMode);
					} else {
						return value;
					}
				}
			} else {
				// EAttributes only store primitives; hand them over directly
				return this.eObject.eGet(feature);
			}
		} else {
			// this should never happen due to checks in calling methods
			throw new IllegalStateException("This method is neither a feature getter nor a feature setter: " + method);
		}
	}

	protected Object getFeatureValueInternal(final Method method, final EStructuralFeature feature) {
		switch (this.featureAccessMode) {
		case VIA_GENERATED_GETTERS_AND_SETTERS:
			try {
				// find the corresponding method in the implementation class...
				Method targetMethod = this.eObject.getClass().getMethod(method.getName(), method.getParameterTypes());
				// ... and call it
				return targetMethod.invoke(this.eObject);
			} catch (NoSuchMethodException | SecurityException e) {
				throw new FeatureResolutionException(
						"The implementation class '" + this.eObject.getClass().getName() + "' for EClass '"
								+ this.eObject.eClass().getName() + "' does not implement the method '" + method + "'!",
						e);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new FeatureResolutionException("The implementation class '" + this.eObject.getClass().getName()
						+ "' for EClass '" + this.eObject.eClass().getName()
						+ "' threw an exception when invoking the method '" + method + "'! See root cause for details.",
						e);
			}
		case VIA_REFLECTIVE_API:
			return this.eObject.eGet(feature);
		default:
			throw new UnknownEnumLiteralException(this.featureAccessMode);
		}
	}

	protected void setFeatureValueInternal(final Method method, final EStructuralFeature feature,
			final Object newValue) {
		switch (this.featureAccessMode) {
		case VIA_GENERATED_GETTERS_AND_SETTERS:
			try {
				// find the corresponding method in the implementation class...
				Method targetMethod = this.eObject.getClass().getMethod(method.getName(), method.getParameterTypes());
				// ... and call it
				targetMethod.invoke(this.eObject, newValue);
			} catch (NoSuchMethodException | SecurityException e) {
				throw new FeatureResolutionException(
						"The implementation class '" + this.eObject.getClass().getName() + "' for EClass '"
								+ this.eObject.eClass().getName() + "' does not implement the method '" + method + "'!",
						e);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new FeatureResolutionException("The implementation class '" + this.eObject.getClass().getName()
						+ "' for EClass '" + this.eObject.eClass().getName()
						+ "' threw an exception when invoking the method '" + method + "'! See root cause for details.",
						e);
			}
			break;
		case VIA_REFLECTIVE_API:
			this.eObject.eSet(feature, newValue);
			break;
		default:
			throw new UnknownEnumLiteralException(this.featureAccessMode);
		}
	}

	// =================================================================================================================
	// INTERNAL HELPER METHODS
	// =================================================================================================================

	protected boolean isEObjectFeatureAccessor(final Method method) {
		checkNotNull(method, "Precondition violation - argument 'method' must not be NULL!");
		if (this.isEObjectFeatureGetter(method)) {
			return true;
		} else if (this.isEObjectFeatureSetter(method)) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean isEObjectFeatureGetter(final Method method) {
		checkNotNull(method, "Precondition violation - argument 'method' must not be NULL!");
		String name = method.getName();
		if ((name.startsWith("get") || name.startsWith("is")) && method.getParameters().length <= 0) {
			if (name.equals("getClass")) {
				// "getClass()" is an exception here because that's the regular Object#getClass()
				// method and therefore not a generated getter.
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	protected boolean isEObjectFeatureSetter(final Method method) {
		checkNotNull(method, "Precondition violation - argument 'method' must not be NULL!");
		String name = method.getName();
		if (name.startsWith("set") && method.getParameters().length == 1) {
			return true;
		}
		return false;
	}

	protected EStructuralFeature getFeatureForAccessorMethod(final Method accessorMethod) {
		checkNotNull(accessorMethod, "Precondition violation - argument 'accessorMethod' must not be NULL!");
		// access the registry to find the corresponding EClass
		// EClass eClass = OdysseusEPackageRegistry.eINSTANCE.getCorrespondingRegisteredEClass(this.eObject.eClass());
		EClass eClass = this.eObject.eClass();
		String featureName = this.getFeatureNameForAccessorMethod(accessorMethod);
		EList<EStructuralFeature> eAllStructuralFeatures = eClass.getEAllStructuralFeatures();
		List<EStructuralFeature> candidateFeatures = Lists.newArrayList();
		for (EStructuralFeature feature : eAllStructuralFeatures) {
			if (feature.getName().equalsIgnoreCase(featureName)) {
				candidateFeatures.add(feature);
			}
		}
		if (candidateFeatures.isEmpty()) {
			// we could not resolve the feature; no feature matched the name of the method
			throw new FeatureNotFoundException("Could not find EStructuralFeature in EClass '"
					+ this.eObject.eClass().getName() + "' for method '" + accessorMethod + "'!");
		} else if (candidateFeatures.size() == 1) {
			// we found the feature
			return Iterables.getOnlyElement(candidateFeatures);
		} else {
			// the reference was ambiguous
			StringBuilder msg = new StringBuilder();
			msg.append("Could not find EStructuralFeature in EClass '");
			msg.append(this.eObject.eClass().getName());
			msg.append("' for method '");
			msg.append(accessorMethod);
			msg.append("': the method is ambiguous! Candidate features are: [");
			String separator = "";
			for (EStructuralFeature feature : candidateFeatures) {
				msg.append(separator);
				separator = ", ";
				if (feature instanceof EAttribute) {
					msg.append("EAttribute ");
				} else if (feature instanceof EReference) {
					msg.append("EReference ");
				} else {
					msg.append("<unknown> ");
				}
				msg.append(feature.getName());
				msg.append(" (");
				msg.append(feature.getEType().getName());
				msg.append(")");
			}
			msg.append("]");
			throw new AmbiguousFeatureException(msg.toString());
		}
	}

	protected String getFeatureNameForAccessorMethod(final Method accessorMethod) {
		checkNotNull(accessorMethod, "Precondition violation - argument 'accessorMethod' must not be NULL!");
		String name = accessorMethod.getName();
		if (name.startsWith("is")) {
			return name.substring(2);
		} else if (name.startsWith("get")) {
			return name.substring(3);
		} else if (name.startsWith("set")) {
			return name.substring(3);
		} else {
			throw new IllegalArgumentException(
					"The given method is not a feature accessor method: '" + accessorMethod + "'!");
		}
	}

	private Class<?> getReferenceInterfaceType(final EReference eReference) {
		checkNotNull(eReference, "Precondition violation - argument 'eReference' must not be NULL!");
		EClass eClass = OdysseusEPackageRegistry.eINSTANCE
				.getCorrespondingRegisteredEClass(eReference.getEReferenceType());
		try {
			return getPrimaryJavaInterfaceForEClass(eClass);
		} catch (IllegalStateException e) {
			throw new IllegalStateException("Could not determine the Interface of the EReferenceType of EReference '"
					+ eReference.getName() + "'! See root cause for details.", e);
		}
	}

}
