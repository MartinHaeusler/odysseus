package org.odysseus.test.edpl;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.odysseus.spi.module.SocialNetworkModule;
import org.junit.Test;
import org.odysseus.internal.spi.loader.OdysseusModuleLoader;
import org.odysseus.spi.OdysseusModule;

public class OdysseusModuleLoaderTest {

	@Test
	public void canDetectSocialNetworkModule() {
		List<OdysseusModule> modules = OdysseusModuleLoader.loadModules();
		List<String> names = modules.stream()
				.map(module -> module.getSimpleName() + " (" + module.getQualifiedName() + ")")
				.collect(Collectors.toList());
		assertTrue(names.size() > 0);
		Optional<OdysseusModule> maybeModule = modules.stream()
				.filter(module -> module.getClass().equals(SocialNetworkModule.class)).findAny();
		assertTrue(maybeModule.isPresent());
	}
}
