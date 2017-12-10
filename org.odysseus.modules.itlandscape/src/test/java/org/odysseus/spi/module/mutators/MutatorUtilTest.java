package org.odysseus.spi.module.mutators;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.regex.Pattern;

import org.junit.Test;
import org.odysseus.spi.DefaultRandomGenerator;
import org.odysseus.spi.RandomGenerator;
import org.odysseus.spi.module.mutators.util.MutatorUtil;

import com.google.common.collect.Maps;

public class MutatorUtilTest {

	@Test
	public void osFamilyGenerationWorks() {
		String osFamily = MutatorUtil.getCommonOSFamily("Ubuntu 16.04", "Ubuntu 16.10");
		assertEquals("Ubuntu", osFamily);
	}

	@Test
	public void physicalMachineNameGenerationWorks() {
		RandomGenerator random = new DefaultRandomGenerator();
		Map<String, Object> state = Maps.newHashMap();
		String name = MutatorUtil.generatePhysicalMachineName(random, state);
		System.out.println(name);
		String regex = "(.*)\\d+";
		assertTrue(Pattern.matches(regex, name));
	}
}
