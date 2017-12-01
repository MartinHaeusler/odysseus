package org.odysseus.spi.module.mutators;

import java.util.Map;

import org.odysseus.modules.itlandscape.Cluster;
import org.odysseus.modules.itlandscape.ItlandscapePackage;
import org.odysseus.modules.itlandscape.PhysicalMachine;
import org.odysseus.modules.itlandscape.ServiceLevelAgreement;
import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.spi.exceptions.NotEnoughElementsException;

public class DeployClusterMutator implements Mutator {

	// cluster settings

	private static final int HIGH_AVAILABILITY_CHANCE = 30;
	private static final int LOAD_BALANCING_CHANCE = 40;

	private static final int CLUSTER_SIZE_MIN = 5;
	private static final int CLUSTER_SIZE_MAX = 100;

	// physical server server settings

	private static final int CPU_CORES_MIN = 1;
	private static final int CPU_CORES_MAX = 8;
	private static final float CLOCK_RATE_MIN = 1.0f;
	private static final float CLOCK_RATE_MAX = 3.8f;
	private static final int RAM_MIN = 2;
	private static final int RAM_MAX = 128;

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException, NotEnoughElementsException {
		Cluster cluster = context.instantiate(ItlandscapePackage.Literals.CLUSTER);
		// a cluster may be high-availability, load balancing, both or neither.
		cluster.setHighAvailability(context.random().nextIntBetween(0, 100) <= HIGH_AVAILABILITY_CHANCE);
		cluster.setLoadBalancing(context.random().nextIntBetween(0, 100) <= LOAD_BALANCING_CHANCE);
		// pick an SLA for this cluster
		cluster.setSla(context.random().pickOne(ServiceLevelAgreement.VALUES));
		// TODO generate name
		// TODO generate description
		// generate the members of the cluster
		int members = context.random().nextIntBetween(CLUSTER_SIZE_MIN, CLUSTER_SIZE_MAX);
		for (int i = 0; i < members; i++) {
			PhysicalMachine physicalMachine = context.instantiate(ItlandscapePackage.Literals.PHYSICAL_MACHINE);
			// TODO generate name
			// TODO generate description
			physicalMachine.setSla(context.random().pickOne(ServiceLevelAgreement.VALUES));
			int cores = context.random().nextIntBetween(CPU_CORES_MIN, CPU_CORES_MAX);
			if (cores > 1 && cores % 2 != 0) {
				// only allow an even number of cores (unless we only have one)
				cores--;
			}
			physicalMachine.setCpuCores(cores);
			physicalMachine.setClockRateGhz(context.random().nextFloatBetween(CLOCK_RATE_MIN, CLOCK_RATE_MAX));
			physicalMachine.setRamGB(this.floorToPowerOf2(context.random().nextIntBetween(RAM_MIN, RAM_MAX)));
			// TODO set operating system (maybe the same for all cluster members?)
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

	private int floorToPowerOf2(final int x) {
		if ((x & x - 1) == 0) {
			// x is already a power of 2
			return x;
		}
		int result = 32 - Integer.numberOfLeadingZeros(x - 1);
		if (result > 0) {
			// the code above always finds the next-greater power of two,
			// we want the next-smaller one so we subtract 1
			result--;
		}
		return (int) Math.pow(2, result);
	}

}
