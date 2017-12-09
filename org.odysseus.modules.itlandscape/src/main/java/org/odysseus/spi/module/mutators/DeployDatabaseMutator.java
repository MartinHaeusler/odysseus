package org.odysseus.spi.module.mutators;

import java.util.List;
import java.util.Map;

import org.odysseus.modules.itlandscape.Database;
import org.odysseus.modules.itlandscape.Host;
import org.odysseus.modules.itlandscape.ItlandscapePackage;
import org.odysseus.modules.itlandscape.ServiceLevelAgreement;
import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.spi.exceptions.NotEnoughElementsException;
import org.odysseus.spi.module.mutators.util.MutatorUtil;

public class DeployDatabaseMutator implements Mutator {

	private static final int MIN_HOSTS = 1;
	private static final int MAX_HOSTS = 10;

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException, NotEnoughElementsException {
		int numberOfHosts = context.random().nextIntBetween(MIN_HOSTS, MAX_HOSTS);
		List<Host> hosts = context.getAnyDistinctInstancesOf(ItlandscapePackage.Literals.HOST, numberOfHosts);
		if (hosts == null || hosts.size() < numberOfHosts) {
			throw new NotEnoughElementsException();
		}
		Database database = context.instantiate(ItlandscapePackage.Literals.DATABASE);
		database.setName(MutatorUtil.generateDatabaseName(context.random(), state));
		database.setSla(context.random().pickOne(ServiceLevelAgreement.VALUES));
		database.getRunsOn().addAll(hosts);
		context.addToModel(database);
	}

	@Override
	public double getBaseLikelyhood() {
		return 35;
	}

	@Override
	public MutatorType getMutatorType() {
		return MutatorType.ADDITION;
	}

	@Override
	public String getName() {
		return "Deploy Database";
	}

}
