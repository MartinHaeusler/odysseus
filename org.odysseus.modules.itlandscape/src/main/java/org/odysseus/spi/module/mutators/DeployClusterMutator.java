package org.odysseus.spi.module.mutators;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.odysseus.modules.itlandscape.Cluster;
import org.odysseus.modules.itlandscape.ItlandscapePackage;
import org.odysseus.modules.itlandscape.PhysicalMachine;
import org.odysseus.modules.itlandscape.ServiceLevelAgreement;
import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.spi.exceptions.NotEnoughElementsException;
import org.odysseus.spi.module.mutators.util.MutatorUtil;
import org.odysseus.spi.module.mutators.util.PhysicalMachines;

public class DeployClusterMutator implements Mutator {

	// cluster settings

	private static final int HIGH_AVAILABILITY_CHANCE = 30;
	private static final int LOAD_BALANCING_CHANCE = 40;

	private static final int CLUSTER_SIZE_MIN = 5;
	private static final int CLUSTER_SIZE_MAX = 100;

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException, NotEnoughElementsException {
		Cluster cluster = context.instantiate(ItlandscapePackage.Literals.CLUSTER);
		// a cluster may be high-availability, load balancing, both or neither.
		cluster.setHighAvailability(context.random().nextIntBetween(0, 100) <= HIGH_AVAILABILITY_CHANCE);
		cluster.setLoadBalancing(context.random().nextIntBetween(0, 100) <= LOAD_BALANCING_CHANCE);
		// pick an SLA for this cluster
		cluster.setSla(context.random().pickOne(ServiceLevelAgreement.VALUES));
		Pair<String, String> osNameAndFamily = MutatorUtil.generateOSNameAndFamily(context.random());
		String osName = osNameAndFamily.getLeft();
		String osFamily = osNameAndFamily.getRight();
		String clusterName = MutatorUtil.generateVirtualHostName(osFamily + " Cluster", state);
		cluster.setName(clusterName);
		// generate the members of the cluster
		int members = context.random().nextIntBetween(CLUSTER_SIZE_MIN, CLUSTER_SIZE_MAX);
		List<String> machineNames = MutatorUtil.generatePhysicalMachineNames(context.random(), members, true, state);
		PhysicalMachine prototype = PhysicalMachines.create(context, state);
		for (int i = 0; i < members; i++) {
			PhysicalMachine physicalMachine = EcoreUtil.copy(prototype);
			physicalMachine.setName(machineNames.get(i));
			physicalMachine.setOperatingSystem(osName);
			context.addToModel(physicalMachine);
			cluster.getRunsOn().add(physicalMachine);
		}
		context.addToModel(cluster);
	}

	@Override
	public double getBaseLikelyhood() {
		return 1;
	}

	@Override
	public MutatorType getMutatorType() {
		return MutatorType.ADDITION;
	}

	@Override
	public String getName() {
		return "Deploy Cluster";
	}

}
