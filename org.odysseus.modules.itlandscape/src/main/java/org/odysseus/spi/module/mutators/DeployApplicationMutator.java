package org.odysseus.spi.module.mutators;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.odysseus.modules.itlandscape.Application;
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

import com.google.common.collect.Lists;

public class DeployApplicationMutator implements Mutator {

	private static final int MIN_HOSTS = 1;
	private static final int MAX_HOSTS = 5;
	private static final int MIN_DATABASES = 0;
	private static final int MAX_DATABASES = 3;

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException, NotEnoughElementsException {
		EClass hostClass = ItlandscapePackage.Literals.HOST;
		EClass databaseClass = ItlandscapePackage.Literals.DATABASE;
		EClass applicationClass = ItlandscapePackage.Literals.APPLICATION;
		int hostCount = context.random().nextIntBetween(MIN_HOSTS, MAX_HOSTS);
		List<Host> hosts = context.getAnyDistinctInstancesOf(hostClass, hostCount, true);
		if (hosts == null || hosts.size() < hostCount) {
			throw new NotEnoughElementsException();
		}
		int databaseCount = context.random().nextIntBetween(MIN_DATABASES, MAX_DATABASES);
		List<Database> databases;
		if (databaseCount <= 0) {
			databases = Lists.newArrayList();
		} else {
			databases = context.getAnyDistinctInstancesOf(databaseClass, databaseCount, true);
		}
		if (databases == null || databases.size() < databaseCount) {
			throw new NotEnoughElementsException();
		}
		// generate the application
		Application application = context.instantiateAndAddToModel(hostClass);
		application.setName(MutatorUtil.generateApplicationName(context.random(), state));
		application.setSla(context.random().pickOne(ServiceLevelAgreement.VALUES));
		application.getRunsOn().addAll(hosts);
		application.getAccesses().addAll(databases);
	}

	@Override
	public double getBaseLikelyhood() {
		return 100;
	}

	@Override
	public MutatorType getMutatorType() {
		return MutatorType.ADDITION;
	}

	@Override
	public String getName() {
		return "Deploy Application";
	}

}
