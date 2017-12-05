package org.odysseus.spi.module.mutators;

import java.util.List;
import java.util.Map;

import org.odysseus.modules.itlandscape.ItlandscapePackage;
import org.odysseus.modules.itlandscape.PhysicalMachine;
import org.odysseus.modules.itlandscape.Storage;
import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.spi.exceptions.NotEnoughElementsException;
import org.odysseus.spi.module.mutators.util.PhysicalMachines;

public class AcquirePhysicalMachine implements Mutator {

	private static final int CONNECTED_STORAGES_MIN = 1;
	private static final int CONNECTED_STORAGES_MAX = 10;

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException, NotEnoughElementsException {
		int storageCount = context.random().nextIntBetween(CONNECTED_STORAGES_MIN, CONNECTED_STORAGES_MAX);
		List<Storage> storages = context.getAnyDistinctInstancesOf(ItlandscapePackage.Literals.STORAGE, storageCount);
		if (storages == null || storages.size() < storageCount) {
			throw new NotEnoughElementsException();
		}
		PhysicalMachine physicalMachine = PhysicalMachines.create(context, state);
		physicalMachine.getUses().addAll(storages);
		context.addToModel(physicalMachine);
	}

	@Override
	public double getBaseLikelyhood() {
		return 25;
	}

	@Override
	public MutatorType getMutatorType() {
		return MutatorType.ADDITION;
	}

	@Override
	public String getName() {
		return "Acquire Physical Machine";
	}

}
