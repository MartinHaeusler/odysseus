package org.odysseus.spi.module.mutators;

import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.emf.ecore.EClass;
import org.odysseus.modules.itlandscape.Cluster;
import org.odysseus.modules.itlandscape.ItlandscapePackage;
import org.odysseus.modules.itlandscape.PhysicalMachine;
import org.odysseus.modules.itlandscape.ServiceLevelAgreement;
import org.odysseus.modules.itlandscape.VirtualMachine;
import org.odysseus.spi.DiscreteProbabilityDistribution;
import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.ProbabilityDistribution;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.spi.exceptions.NotEnoughElementsException;
import org.odysseus.spi.module.mutators.util.MutatorUtil;

public class CreateVirtualMachineMutator implements Mutator {

	// =================================================================================================================
	// SETTINGS
	// =================================================================================================================

	private static final float WEIGHT__VM_ON_VM = 0.03f;
	private static final float WEIGHT__VM_ON_PHYSICAL = 0.15f;
	private static final float WEIGHT__VM_ON_CLUSTER = 0.82f;

	// =================================================================================================================
	// PUBLIC API
	// =================================================================================================================

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException, NotEnoughElementsException {

		//@formatter:off
		DiscreteProbabilityDistribution<DeploymentType> distribution = ProbabilityDistribution
			.<DeploymentType>discrete(context.random())
			.event(DeploymentType.VM_ON_VM, WEIGHT__VM_ON_VM)
			.event(DeploymentType.VM_ON_PHYSICAL, WEIGHT__VM_ON_PHYSICAL)
			.event(DeploymentType.VM_ON_CLUSTER, WEIGHT__VM_ON_CLUSTER)
			.build();
		//@formatter:on

		DeploymentType deploymentType = distribution.nextEvent();
		VirtualMachine vm = null;
		switch (deploymentType) {
		case VM_ON_VM:
			vm = this.createVmOnVm(context, state);
			break;
		case VM_ON_PHYSICAL:
			vm = this.createVmOnPhysical(context, state);
			break;
		case VM_ON_CLUSTER:
			vm = this.createVmOnCluster(context, state);
			break;
		default:
			throw new RuntimeException(
					"Unknown literal of '" + DeploymentType.class.getName() + "': '" + deploymentType + "'!");
		}
		if (vm == null) {
			throw new ModificationNotApplicableException();
		}
		context.addToModel(vm);
	}

	@Override
	public double getBaseLikelyhood() {
		return 50;
	}

	@Override
	public MutatorType getMutatorType() {
		return MutatorType.ADDITION;
	}

	@Override
	public String getName() {
		return "Create Virtual Machine";
	}

	// =================================================================================================================
	// HELPER METHODS
	// =================================================================================================================

	private VirtualMachine createVmOnVm(final ModelGenerationContext context, final Map<String, Object> state) {
		EClass ecVirtualMachine = ItlandscapePackage.Literals.VIRTUAL_MACHINE;
		VirtualMachine hostVM = context.getAnyInstanceOf(ecVirtualMachine);
		if (hostVM == null) {
			return null;
		}
		VirtualMachine clientVM = this.createVirtualMachine(context, state);
		clientVM.getRunsOn().add(hostVM);
		int cores = 1;
		if (hostVM.getCpuCores() > 1) {
			cores = context.random().nextIntBetween(1, hostVM.getCpuCores());
		}
		clientVM.setCpuCores(cores);
		int ram = 1;
		if (hostVM.getRamGB() > 1) {
			ram = context.random().nextIntBetween(1, hostVM.getRamGB());
		}
		clientVM.setRamGB(ram);
		return clientVM;
	}

	private VirtualMachine createVmOnPhysical(final ModelGenerationContext context, final Map<String, Object> state) {
		EClass ecPhysicalMachine = ItlandscapePackage.Literals.PHYSICAL_MACHINE;
		PhysicalMachine hostMachine = context.getAnyInstanceOf(ecPhysicalMachine);
		if (hostMachine == null) {
			return null;
		}
		VirtualMachine clientVM = this.createVirtualMachine(context, state);
		clientVM.getRunsOn().add(hostMachine);
		int cores = 1;
		if (hostMachine.getCpuCores() > 1) {
			cores = context.random().nextIntBetween(1, hostMachine.getCpuCores());
		}
		int ram = 1;
		if (hostMachine.getRamGB() > 1) {
			ram = context.random().nextIntBetween(1, hostMachine.getRamGB());
		}
		clientVM.setCpuCores(cores);
		clientVM.setRamGB(ram);
		return clientVM;
	}

	private VirtualMachine createVmOnCluster(final ModelGenerationContext context, final Map<String, Object> state) {
		EClass ecCluster = ItlandscapePackage.Literals.CLUSTER;
		Cluster hostCluster = context.getAnyInstanceOf(ecCluster);
		if (hostCluster == null) {
			return null;
		}
		VirtualMachine clientVM = this.createVirtualMachine(context, state);
		clientVM.getRunsOn().add(hostCluster);
		clientVM.setCpuCores(context.random().nextIntBetween(1, 16));
		clientVM.setRamGB(context.random().nextIntBetween(1, 128));
		return clientVM;
	}

	private VirtualMachine createVirtualMachine(final ModelGenerationContext context, final Map<String, Object> state) {
		VirtualMachine vm = context.instantiate(ItlandscapePackage.Literals.VIRTUAL_MACHINE);
		Pair<String, String> osAndFamily = MutatorUtil.generateOSNameAndFamily(context.random());
		vm.setName(MutatorUtil.generateVirtualHostName(osAndFamily.getRight(), state));
		vm.setOperatingSystem(osAndFamily.getLeft());
		vm.setSla(context.random().pickOne(ServiceLevelAgreement.VALUES));
		vm.setIp(MutatorUtil.generateIpAdress(context.random()));
		return vm;
	}

	// =================================================================================================================
	// INNER CLASSES
	// =================================================================================================================

	private static enum DeploymentType {

		VM_ON_VM, VM_ON_CLUSTER, VM_ON_PHYSICAL,
	}
}
