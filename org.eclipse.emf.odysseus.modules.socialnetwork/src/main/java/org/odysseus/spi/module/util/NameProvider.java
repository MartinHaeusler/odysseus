package org.odysseus.spi.module.util;

import java.util.Collections;
import java.util.List;

import org.odysseus.models.socialnetwork.user.Gender;
import org.odysseus.spi.RandomGenerator;

public class NameProvider {

	private static final List<String> FIRST_NAMES_FEMALE;
	private static final List<String> FIRST_NAMES_MALE;
	private static final List<String> LAST_NAMES;
	private static final List<String> GROUP_NAMES;

	static {
		FIRST_NAMES_FEMALE = Collections
				.unmodifiableList(ClassloaderUtils.resourceFileToLines("BaseData/firstNames_female.csv"));
		FIRST_NAMES_MALE = Collections
				.unmodifiableList(ClassloaderUtils.resourceFileToLines("BaseData/firstNames_male.csv"));
		LAST_NAMES = Collections.unmodifiableList(ClassloaderUtils.resourceFileToLines("BaseData/lastNames.csv"));
		GROUP_NAMES = Collections.unmodifiableList(ClassloaderUtils.resourceFileToLines("BaseData/groupNames.csv"));
	}

	public static String randomFirstName(final RandomGenerator generator, final Gender gender) {
		switch (gender) {
		case FEMALE:
			return generator.pickOne(FIRST_NAMES_FEMALE);
		case MALE:
			return generator.pickOne(FIRST_NAMES_MALE);
		default:
			throw new RuntimeException("Unknown Gender: '" + gender + "'!");
		}
	}

	public static String randomLastName(final RandomGenerator generator) {
		return generator.pickOne(LAST_NAMES);
	}

	public static String randomGroupName(final RandomGenerator generator) {
		return generator.pickOne(GROUP_NAMES);
	}
}
