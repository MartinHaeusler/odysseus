package org.odysseus.internal.configuration;

import static com.google.common.base.Preconditions.*;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.odysseus.api.configuration.EObjectFactory;
import org.odysseus.api.configuration.EcoreConfiguration;
import org.odysseus.exceptions.OdysseusConfigurationException;

public class EcoreConfigurationImpl implements EcoreConfiguration {

	// =================================================================================================================
	// FIELDS
	// =================================================================================================================

	protected FeatureAccessMode featureAccessMode;
	protected EObjectFactory eObjectFactory;

	// =================================================================================================================
	// CONSTRUCTOR
	// =================================================================================================================

	public EcoreConfigurationImpl() {
		// set up some defaults
		this.featureAccessMode = FeatureAccessMode.VIA_REFLECTIVE_API;
		this.eObjectFactory = EcoreUtil::create;
	}

	// =================================================================================================================
	// PUBLIC API
	// =================================================================================================================

	@Override
	public FeatureAccessMode getFeatureAccessMode() {
		return this.featureAccessMode;
	}

	@Override
	public void setFeatureAccessMode(final FeatureAccessMode featureAccessMode) {
		checkNotNull(featureAccessMode, "Precondition violation - argument 'featureAccessMode' must not be NULL!");
		this.featureAccessMode = featureAccessMode;
	}

	@Override
	public EObjectFactory getEObjectFactory() {
		return this.eObjectFactory;
	}

	@Override
	public void setEObjectFactory(final EObjectFactory factory) {
		checkNotNull(factory, "Precondition violation - argument 'factory' must not be NULL!");
		this.eObjectFactory = factory;
	}

	// =================================================================================================================
	// VALIDATION
	// =================================================================================================================

	@Override
	public void validate() throws OdysseusConfigurationException {
		if (this.featureAccessMode == null) {
			throw new OdysseusConfigurationException("No FeatureAccessMode was set up in Ecore configuration!");
		}
		if (this.eObjectFactory == null) {
			throw new OdysseusConfigurationException("No EObjectFactory was set up in Ecore configuration!");
		}
	}
}
