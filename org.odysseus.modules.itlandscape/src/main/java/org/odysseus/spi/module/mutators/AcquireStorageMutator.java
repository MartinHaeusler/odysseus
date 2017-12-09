package org.odysseus.spi.module.mutators;

import java.util.Map;

import org.odysseus.modules.itlandscape.ItlandscapePackage;
import org.odysseus.modules.itlandscape.ServiceLevelAgreement;
import org.odysseus.modules.itlandscape.Storage;
import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.spi.exceptions.NotEnoughElementsException;
import org.odysseus.spi.module.mutators.util.MutatorUtil;

public class AcquireStorageMutator implements Mutator {

	private final int STORAGE_CAPACITY_MIN = 128;
	private final int STORAGE_CAPACITY_MAX = 8192;

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException, NotEnoughElementsException {
		Storage storage = context.instantiate(ItlandscapePackage.Literals.STORAGE);
		storage.setName(MutatorUtil.generateStorageName(context.random(), state));
		storage.setSla(context.random().pickOne(ServiceLevelAgreement.VALUES));
		storage.setCapacity(context.random().nextIntBetween(this.STORAGE_CAPACITY_MIN, this.STORAGE_CAPACITY_MAX));
		context.addToModel(storage);
	}

	@Override
	public double getBaseLikelyhood() {
		return 30;
	}

	@Override
	public MutatorType getMutatorType() {
		return MutatorType.ADDITION;
	}

	@Override
	public String getName() {
		return "Acquire Storage";
	}

}
