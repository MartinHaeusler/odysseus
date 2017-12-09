package org.odysseus.spi.module.mutators;

import static org.junit.Assert.*;

import org.junit.Test;
import org.odysseus.spi.module.mutators.util.MutatorUtil;

public class MutatorUtilTest {

	@Test
	public void osFamilyGenerationWorks() {
		String osFamily = MutatorUtil.getCommonOSFamily("Ubuntu 16.04", "Ubuntu 16.10");
		assertEquals("Ubuntu", osFamily);
	}
}
