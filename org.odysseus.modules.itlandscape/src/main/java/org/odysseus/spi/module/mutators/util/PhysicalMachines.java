package org.odysseus.spi.module.mutators.util;

import java.util.Map;

import org.odysseus.modules.itlandscape.ItlandscapePackage;
import org.odysseus.modules.itlandscape.PhysicalMachine;
import org.odysseus.modules.itlandscape.ServiceLevelAgreement;
import org.odysseus.spi.ModelGenerationContext;

public class PhysicalMachines {

	private static final int CPU_CORES_MIN = 1;
	private static final int CPU_CORES_MAX = 8;
	private static final float CLOCK_RATE_MIN = 1.0f;
	private static final float CLOCK_RATE_MAX = 3.8f;
	private static final int RAM_MIN = 8;
	private static final int RAM_MAX = 128;

	public static PhysicalMachine create(final ModelGenerationContext context, final Map<String, Object> state) {
		PhysicalMachine physicalMachine = context.instantiate(ItlandscapePackage.Literals.PHYSICAL_MACHINE);
		physicalMachine.setSla(context.random().pickOne(ServiceLevelAgreement.VALUES));
		int cores = context.random().nextIntBetween(CPU_CORES_MIN, CPU_CORES_MAX);
		if (cores > 1 && cores % 2 != 0) {
			// only allow an even number of cores (unless we only have one)
			cores--;
		}
		physicalMachine.setCpuCores(cores);
		physicalMachine.setClockRateGhz(context.random().nextFloatBetween(CLOCK_RATE_MIN, CLOCK_RATE_MAX));
		physicalMachine.setRamGB(floorToPowerOf2(context.random().nextIntBetween(RAM_MIN, RAM_MAX)));
		physicalMachine.setName(MutatorUtil.generatePhysicalMachineName(context.random(), state));
		physicalMachine.setOperatingSystem(MutatorUtil.generateOSName(context.random()));
		return physicalMachine;
	}

	private static int floorToPowerOf2(final int x) {
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
