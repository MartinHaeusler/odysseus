package org.odysseus.spi;

import java.util.Collection;

import org.eclipse.emf.ecore.EPackage;

public interface OdysseusModule {

	// =================================================================================================================
	// METADATA
	// =================================================================================================================

	public String getQualifiedName();

	public String getSimpleName();

	public String getVendor();

	public String getVersion();

	// =================================================================================================================
	// CONTENT
	// =================================================================================================================

	public Collection<? extends EPackage> getEPackages();

	public Collection<? extends Mutator> getMutators();

}
