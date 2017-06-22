package org.odysseus.api.configuration;

import org.odysseus.internal.configuration.FeatureAccessMode;

public interface EcoreConfiguration extends PartialOdysseusConfiguration {

	public FeatureAccessMode getFeatureAccessMode();

	public void setFeatureAccessMode(FeatureAccessMode featureAccessMode);

	public EObjectFactory getEObjectFactory();

	public void setEObjectFactory(EObjectFactory factory);

}
