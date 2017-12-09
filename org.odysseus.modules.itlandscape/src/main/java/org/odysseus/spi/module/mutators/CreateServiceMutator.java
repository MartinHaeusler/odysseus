package org.odysseus.spi.module.mutators;

import java.util.List;
import java.util.Map;

import org.odysseus.modules.itlandscape.Application;
import org.odysseus.modules.itlandscape.ItlandscapePackage;
import org.odysseus.modules.itlandscape.Service;
import org.odysseus.modules.itlandscape.ServiceLevelAgreement;
import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.spi.exceptions.NotEnoughElementsException;
import org.odysseus.spi.module.mutators.util.MutatorUtil;

public class CreateServiceMutator implements Mutator {

	private static final int APP_DEPENDENCIES_MIN = 3;
	private static final int APP_DEPENDENCIES_MAX = 8;

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException, NotEnoughElementsException {
		int applicationDependencyCount = context.random().nextIntBetween(APP_DEPENDENCIES_MIN, APP_DEPENDENCIES_MAX);
		List<Application> dependencies = context.getAnyDistinctInstancesOf(ItlandscapePackage.Literals.APPLICATION,
				applicationDependencyCount);
		if (dependencies == null || dependencies.size() < applicationDependencyCount) {
			throw new NotEnoughElementsException();
		}
		Service service = context.instantiate(ItlandscapePackage.Literals.SERVICE);
		service.setName(MutatorUtil.generateServiceName(state));
		service.setSla(context.random().pickOne(ServiceLevelAgreement.VALUES));
		service.getDependsOn().addAll(dependencies);
		context.addToModel(service);
	}

	@Override
	public double getBaseLikelyhood() {
		return 15;
	}

	@Override
	public MutatorType getMutatorType() {
		return MutatorType.ADDITION;
	}

	@Override
	public String getName() {
		return "Create Service";
	}

}
