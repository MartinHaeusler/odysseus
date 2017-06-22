package org.odysseus.spi;

import java.util.Map;

import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.spi.exceptions.NotEnoughElementsException;

public interface Mutator {

	public String getName();

	public MutatorType getMutatorType();

	public double getBaseLikelyhood();

	public void apply(ModelGenerationContext context, Map<String, Object> state)
			throws ModificationNotApplicableException, NotEnoughElementsException;

}
