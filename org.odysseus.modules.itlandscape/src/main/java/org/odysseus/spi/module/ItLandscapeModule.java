package org.odysseus.spi.module;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.odysseus.modules.itlandscape.ItlandscapePackage;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.OdysseusModule;

import com.google.common.collect.Lists;

public class ItLandscapeModule implements OdysseusModule {

	@Override
	public Collection<? extends EPackage> getEPackages() {
		List<EPackage> ePackages = Lists.newArrayList();
		ePackages.add(ItlandscapePackage.eINSTANCE);
		return ePackages;
	}

	@Override
	public Collection<? extends Mutator> getMutators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSimpleName() {
		return "IT Landscape";
	}

	@Override
	public String getQualifiedName() {
		return "org.odysseus.models.itlandscape";
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
