package org.odysseus.internal.configuration;

import static com.google.common.base.Preconditions.*;

import org.odysseus.api.configuration.RandomConfiguration;
import org.odysseus.exceptions.OdysseusConfigurationException;
import org.odysseus.spi.DefaultRandomGenerator;
import org.odysseus.spi.RandomGenerator;

public class RandomConfigurationImpl implements RandomConfiguration {

	// =================================================================================================================
	// FIELDS
	// =================================================================================================================

	protected long randomSeed;
	protected RandomGenerator generator;

	// =================================================================================================================
	// CONSTRUCTOR
	// =================================================================================================================

	public RandomConfigurationImpl() {
		this.randomSeed = System.currentTimeMillis();
		this.generator = new DefaultRandomGenerator(this.randomSeed);
	}

	// =================================================================================================================
	// PUBLIC API [CONFIGURATION]
	// =================================================================================================================

	@Override
	public long getRandomSeed() {
		return this.randomSeed;
	}

	@Override
	public void setRandomSeed(final long value) {
		this.randomSeed = value;
		this.generator.setSeed(value);
	}

	@Override
	public void setRandomSeed(final String value) {
		checkNotNull(value, "Precondition violation - argument 'value' must not be NULL!");
		this.setRandomSeed(value.hashCode());
	}

	@Override
	public RandomGenerator getGenerator() {
		return this.generator;
	}

	@Override
	public void setGenerator(final RandomGenerator generator) {
		checkNotNull(generator, "Precondition violation - argument 'generator' must not be NULL!");
		this.generator = generator;
		this.generator.setSeed(this.randomSeed);
	}

	// =================================================================================================================
	// PUBLIC API [VALIDATION]
	// =================================================================================================================

	@Override
	public void validate() throws OdysseusConfigurationException {
		if (this.generator == null) {
			throw new OdysseusConfigurationException("No Random Generator is set up in Random configuration!");
		}
	}

}
