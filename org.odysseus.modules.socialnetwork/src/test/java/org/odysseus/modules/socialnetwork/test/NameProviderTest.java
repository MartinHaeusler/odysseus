package org.odysseus.modules.socialnetwork.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.odysseus.models.socialnetwork.user.Gender;
import org.odysseus.spi.DefaultRandomGenerator;
import org.odysseus.spi.RandomGenerator;
import org.odysseus.spi.module.util.NameProvider;

public class NameProviderTest {

	@Test
	public void canGenerateFirstNames() {
		RandomGenerator random = new DefaultRandomGenerator();
		String firstNameMale = NameProvider.randomFirstName(random, Gender.MALE);
		assertNotNull(firstNameMale);
		String firstNameFemale = NameProvider.randomFirstName(random, Gender.FEMALE);
		assertNotNull(firstNameFemale);
	}

	@Test
	public void canGenerateLastNames() {
		RandomGenerator random = new DefaultRandomGenerator();
		String randomLastName = NameProvider.randomLastName(random);
		assertNotNull(randomLastName);
	}
}
