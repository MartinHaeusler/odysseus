package org.odysseus.api.configuration;

import org.odysseus.spi.RandomGenerator;

public interface RandomConfiguration extends PartialOdysseusConfiguration {

	public long getRandomSeed();

	public void setRandomSeed(long value);

	public void setRandomSeed(String value);

	public RandomGenerator getGenerator();

	public void setGenerator(RandomGenerator generator);

}
