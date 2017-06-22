package org.odysseus.internal;

import static com.google.common.base.Preconditions.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.odysseus.exceptions.OdysseusModuleLoadingException;
import org.odysseus.internal.spi.loader.OdysseusModuleLoader;
import org.odysseus.internal.util.EMFUtils;
import org.odysseus.spi.OdysseusModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

public final class OdysseusEPackageRegistry {

	private static final Logger LOG = LoggerFactory.getLogger(OdysseusEPackageRegistry.class);

	// =================================================================================================================
	// SINGLETON IMPLEMENTATION
	// =================================================================================================================

	public static final OdysseusEPackageRegistry eINSTANCE = new OdysseusEPackageRegistry();

	private OdysseusEPackageRegistry() {
		List<OdysseusModule> modules = OdysseusModuleLoader.loadModules();
		for (OdysseusModule module : modules) {
			try {
				Collection<? extends EPackage> ePackages = module.getEPackages();
				for (EPackage ePackage : ePackages) {
					if (this.isEPackageRegistered(ePackage)) {
						LOG.warn("Detected ambiguous EPackage name: " + EMFUtils.fullyQualifiedNameFor(ePackage));
						continue;
					}
					this.registerEPackage(ePackage);
				}
			} catch (Exception e) {
				throw new OdysseusModuleLoadingException("The module '" + module.getSimpleName() + " ("
						+ module.getQualifiedName() + ") failed to load!");
			}
		}
	}

	// =================================================================================================================
	// FIELDS
	// =================================================================================================================

	private Map<String, EClass> eClasses = Maps.newHashMap();
	private Map<String, EPackage> ePackages = Maps.newHashMap();

	// =================================================================================================================
	// PUBLIC API
	// =================================================================================================================

	public synchronized void initialize() {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
	}

	public synchronized boolean isEPackageRegistered(final EPackage ePackage) {
		checkNotNull(ePackage, "Precondition violation - argument 'ePackage' must not be NULL!");
		return this.ePackages.containsKey(EMFUtils.fullyQualifiedNameFor(ePackage));
	}

	public synchronized void ensureEPackageIsRegistered(final EPackage ePackage) {
		if (this.isEPackageRegistered(ePackage)) {
			return;
		}
		this.registerEPackage(ePackage);
	}

	public synchronized void registerEPackage(final EPackage ePackage) {
		checkNotNull(ePackage, "Precondition violation - argument 'ePackage' must not be NULL!");
		Map<String, EClass> newEClasses = Maps.newHashMap();
		Map<String, EPackage> newEPackages = Maps.newHashMap();
		Set<EPackage> ePackages = EMFUtils.flattenEPackage(ePackage);
		for (EPackage ePack : ePackages) {
			newEPackages.put(EMFUtils.fullyQualifiedNameFor(ePack), ePack);
			for (EClassifier eClassifier : ePack.getEClassifiers()) {
				if (eClassifier instanceof EClass == false) {
					continue;
				}
				EClass eClass = (EClass) eClassifier;
				newEClasses.put(EMFUtils.fullyQualifiedNameFor(eClass), eClass);
			}
		}
		// check if any new keys are already contained
		for (String key : newEPackages.keySet()) {
			if (this.ePackages.containsKey(key)) {
				throw new IllegalStateException("EPackage is already registered: '" + key + "'!");
			}
		}
		for (String key : newEClasses.keySet()) {
			if (this.eClasses.containsKey(key)) {
				throw new IllegalStateException("EClass is already registered: '" + key + "'!");
			}
		}
		// register the new EClasses and EPackages
		this.ePackages.putAll(newEPackages);
		this.eClasses.putAll(newEClasses);
	}

	public synchronized EPackage getEPackage(final String ePackageQualifiedName) {
		checkNotNull(ePackageQualifiedName,
				"Precondition violation - argument 'ePackageQualifiedName' must not be NULL!");
		EPackage ePackage = this.ePackages.get(ePackageQualifiedName);
		if (ePackage == null) {
			throw new IllegalStateException(
					"There is no registered EPackage with qualified name: '" + ePackageQualifiedName + "'!");
		}
		return ePackage;
	}

	public synchronized EPackage getCorrespondingRegisteredEPackage(final EPackage ePackage) {
		checkNotNull(ePackage, "Precondition violation - argument 'ePackage' must not be NULL!");
		return this.getEPackage(EMFUtils.fullyQualifiedNameFor(ePackage));
	}

	public synchronized EClass getEClass(final String eClassQualifiedName) {
		checkNotNull(eClassQualifiedName, "Precondition violation - argument 'eClassQualifiedName' must not be NULL!");
		EClass eClass = this.eClasses.get(eClassQualifiedName);
		if (eClass == null) {
			throw new IllegalStateException(
					"There is no registered EClass with qualified name: '" + eClassQualifiedName + "'!");
		}
		return eClass;
	}

	public synchronized EClass getCorrespondingRegisteredEClass(final EClass eClass) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		return this.getEClass(EMFUtils.fullyQualifiedNameFor(eClass));
	}

}
