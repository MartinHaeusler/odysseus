package org.odysseus.spi.module.mutators;

import java.util.List;
import java.util.Map;

import org.odysseus.modules.itlandscape.Application;
import org.odysseus.modules.itlandscape.ItlandscapePackage;
import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.spi.exceptions.NotEnoughElementsException;

public class AddApplicationDependencyMutator implements Mutator {

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException, NotEnoughElementsException {
		List<Application> apps = context.getAnyDistinctInstancesOf(ItlandscapePackage.Literals.APPLICATION, 10);
		// find two applications which do not have a dependency to each other
		Application depSource = null;
		Application depTarget = null;
		for (Application app1 : apps) {
			for (Application app2 : apps) {
				if (app1.equals(app2)) {
					// an application can't have dependency to itself
					continue;
				}
				if (app1.getDependsOn().contains(app2) == false) {
					depSource = app1;
					depTarget = app2;
					break;
				}
			}
		}
		if (depSource == null || depTarget == null) {
			throw new NotEnoughElementsException();
		}
		depSource.getDependsOn().add(depTarget);
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
		return "Add Application Dependency";
	}

}
