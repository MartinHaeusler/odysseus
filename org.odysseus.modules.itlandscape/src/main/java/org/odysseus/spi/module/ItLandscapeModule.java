package org.odysseus.spi.module;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.odysseus.modules.itlandscape.ItlandscapePackage;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.OdysseusModule;
import org.odysseus.spi.module.mutators.AcquirePhysicalMachineMutator;
import org.odysseus.spi.module.mutators.AcquireStorageMutator;
import org.odysseus.spi.module.mutators.AddApplicationDependencyMutator;
import org.odysseus.spi.module.mutators.CreateServiceMutator;
import org.odysseus.spi.module.mutators.CreateVirtualMachineMutator;
import org.odysseus.spi.module.mutators.DeployApplicationMutator;
import org.odysseus.spi.module.mutators.DeployClusterMutator;
import org.odysseus.spi.module.mutators.DeployDatabaseMutator;

import com.google.common.collect.Lists;

public class ItLandscapeModule implements OdysseusModule {

	private final List<Mutator> mutators = Collections.unmodifiableList(Lists.newArrayList(
			//
			new DeployClusterMutator(), // --
			new DeployApplicationMutator(), // --
			new DeployDatabaseMutator(), // --
			new AcquirePhysicalMachineMutator(), // --
			new AcquireStorageMutator(), // --
			new AddApplicationDependencyMutator(), // --
			new CreateVirtualMachineMutator(), // --
			new CreateServiceMutator() // --
	//
	));

	@Override
	public Collection<? extends EPackage> getEPackages() {
		List<EPackage> ePackages = Lists.newArrayList();
		ePackages.add(ItlandscapePackage.eINSTANCE);
		return ePackages;
	}

	@Override
	public Collection<? extends Mutator> getMutators() {
		return this.mutators;
	}

	@Override
	public String getSimpleName() {
		return "IT Landscape";
	}

	@Override
	public String getQualifiedName() {
		return "org.odysseus.modules.itlandscape";
	}

	@Override
	public String getVendor() {
		return "Martin Haeusler (martin.haeusler@uibk.ac.at)";
	}

	@Override
	public String getVersion() {
		return "0.0.1";
	}

}
