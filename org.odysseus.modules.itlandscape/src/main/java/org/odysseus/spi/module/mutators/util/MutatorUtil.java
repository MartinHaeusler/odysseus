package org.odysseus.spi.module.mutators.util;

import static com.google.common.base.Preconditions.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.odysseus.spi.RandomGenerator;

import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.MultimapBuilder.ListMultimapBuilder;
import com.google.common.collect.Multimaps;

public class MutatorUtil {

	// =================================================================================================================
	// RESOURCE FILE PATHS
	// =================================================================================================================

	private static final String RESOURCE_FILE__OPERATING_SYSTEMS = "BaseData/operatingSystems.csv";
	private static final String RESOURCE_FILE__PHYSICAL_MACHINE_NAMES = "BaseData/physicalMachineNames.csv";
	private static final String RESOURCE_FILE__APPLICATION_NAMES = "BaseData/applications.csv";
	private static final String RESOURCE_FILE__STORAGE_NAMES = "BaseData/storageSystems.csv";
	private static final String RESOURCE_FILE__DATABASE_NAMES = "BaseData/databaseNames.csv";

	// =================================================================================================================
	// CACHES
	// =================================================================================================================

	private static final List<String> OS_NAMES;
	private static final List<String> PHYSICAL_MACHINE_NAMES;
	private static final List<String> APPLICATION_NAMES;
	private static final List<String> STORAGE_NAMES;
	private static final List<String> DATABASE_NAMES;

	private static final List<String> OS_FAMILIES;
	private static final ListMultimap<String, String> OS_NAMES_BY_FAMILY;

	// =================================================================================================================
	// OTHER CONSTANTS
	// =================================================================================================================

	private static final String MUTATOR_STATE_NAME_USAGE_PREFIX = "nameUsage";

	static {
		List<String> osNames = ClassloaderUtils.resourceFileToLines(RESOURCE_FILE__OPERATING_SYSTEMS);
		// ignore comma
		osNames = osNames.stream().map(name -> name.replaceAll(",", "")).collect(Collectors.toList());
		OS_NAMES = Collections.unmodifiableList(osNames);

		List<String> physicalMachineNames = ClassloaderUtils.resourceFileToLines(RESOURCE_FILE__PHYSICAL_MACHINE_NAMES);
		// ignore comma
		physicalMachineNames = physicalMachineNames.stream().map(name -> name.replaceAll(",", ""))
				.collect(Collectors.toList());
		PHYSICAL_MACHINE_NAMES = Collections.unmodifiableList(physicalMachineNames);

		ListMultimap<String, String> osNamesByFamily = ListMultimapBuilder.hashKeys().arrayListValues().build();
		List<String> osFamilies = Lists.newArrayList();
		for (String os1 : OS_NAMES) {
			for (String os2 : OS_NAMES) {
				if (os1.equals(os2)) {
					continue;
				}
				String family = getCommonOSFamily(os1, os2).trim();
				if (family.isEmpty()) {
					continue;
				}
				if (osNamesByFamily.containsEntry(family, os1) == false) {
					osNamesByFamily.put(family, os1);
				}
				if (osNamesByFamily.containsEntry(family, os2) == false) {
					osNamesByFamily.put(family, os2);
				}
				if (osFamilies.contains(family) == false) {
					osFamilies.add(family);
				}
			}
		}
		OS_FAMILIES = Collections.unmodifiableList(osFamilies);
		OS_NAMES_BY_FAMILY = Multimaps.unmodifiableListMultimap(osNamesByFamily);

		List<String> applicationNames = ClassloaderUtils.resourceFileToLines(RESOURCE_FILE__APPLICATION_NAMES);
		// ignore comma
		applicationNames = applicationNames.stream().map(name -> name.replaceAll(",", "")).collect(Collectors.toList());
		APPLICATION_NAMES = Collections.unmodifiableList(applicationNames);

		List<String> storageNames = ClassloaderUtils.resourceFileToLines(RESOURCE_FILE__STORAGE_NAMES);
		// ignore comma
		storageNames = storageNames.stream().map(name -> name.replaceAll(",", "")).collect(Collectors.toList());
		STORAGE_NAMES = Collections.unmodifiableList(storageNames);

		List<String> databaseNames = ClassloaderUtils.resourceFileToLines(RESOURCE_FILE__DATABASE_NAMES);
		// ignore comma
		databaseNames = databaseNames.stream().map(name -> name.replaceAll(",", "")).collect(Collectors.toList());
		DATABASE_NAMES = Collections.unmodifiableList(databaseNames);
	}

	public static String generatePhysicalMachineName(final RandomGenerator random,
			final Map<String, Object> mutatorState) {
		return generatePhysicalMachineName(random, createUsageAppender(mutatorState));
	}

	public static String generatePhysicalMachineName(final RandomGenerator random,
			final Function<String, String> nameTransformation) {
		return Iterables.getOnlyElement(generatePhysicalMachineNames(random, 1, true, nameTransformation));
	}

	public static List<String> generatePhysicalMachineNames(final RandomGenerator random, final int count,
			final boolean sameType, final Map<String, Object> mutatorState) {
		return generatePhysicalMachineNames(random, count, sameType, createUsageAppender(mutatorState));
	}

	public static String generateVirtualHostName(final String baseName, final Map<String, Object> mutatorState) {
		Function<String, String> usageAppender = createUsageAppender(mutatorState);
		return usageAppender.apply(baseName);
	}

	public static String generateApplicationName(final RandomGenerator random, final Map<String, Object> mutatorState) {
		Function<String, String> usageAppender = createUsageAppender(mutatorState);
		String baseName = random.pickOne(APPLICATION_NAMES);
		return usageAppender.apply(baseName);
	}

	public static List<String> generatePhysicalMachineNames(final RandomGenerator random, final int count,
			final boolean sameType, final Function<String, String> nameTransformation) {
		checkNotNull(random, "Precondition violation - argument 'random' must not be NULL!");
		checkArgument(count > 0, "Precondition violation - argument 'count' must not be negative!");
		checkNotNull(nameTransformation, "Precondition violation - argument 'nameTransformation' must not be NULL!");
		List<String> names = null;
		if (sameType) {
			String os = random.pickOne(PHYSICAL_MACHINE_NAMES);
			names = Lists.newArrayList();
			for (int i = 0; i < count; i++) {
				names.add(os);
			}
		} else {
			names = random.pick(PHYSICAL_MACHINE_NAMES, count, false);
		}
		names.stream().map(nameTransformation).collect(Collectors.toList());
		return names;
	}

	public static String generateStorageName(final RandomGenerator random, final Map<String, Object> mutatorState) {
		checkNotNull(random, "Precondition violation - argument 'random' must not be NULL!");
		checkNotNull(mutatorState, "Precondition violation - argument 'mutatorState' must not be NULL!");
		Function<String, String> usageAppender = createUsageAppender(mutatorState);
		String baseName = random.pickOne(STORAGE_NAMES);
		return usageAppender.apply(baseName);
	}

	public static String generateServiceName(final Map<String, Object> mutatorState) {
		checkNotNull(mutatorState, "Precondition violation - argument 'mutatorState' must not be NULL!");
		Function<String, String> usageAppender = createUsageAppender(mutatorState);
		String baseName = "IT Service"; // TODO maybe we can come up with a better name here?
		return usageAppender.apply(baseName);
	}

	public static String generateDatabaseName(final RandomGenerator random, final Map<String, Object> mutatorState) {
		checkNotNull(random, "Precondition violation - argument 'random' must not be NULL!");
		checkNotNull(mutatorState, "Precondition violation - argument 'mutatorState' must not be NULL!");
		String baseName = random.pickOne(DATABASE_NAMES);
		Function<String, String> usageAppender = createUsageAppender(mutatorState);
		return usageAppender.apply(baseName);
	}

	public static String generateOSName(final RandomGenerator random) {
		checkNotNull(random, "Precondition violation - argument 'random' must not be NULL!");
		return Iterables.getOnlyElement(generateOSNames(random, 1, OsNames.RANDOM));
	}

	public static Pair<String, String> generateOSNameAndFamily(final RandomGenerator random) {
		checkNotNull(random, "Precondition violation - argument 'random' must not be NULL!");
		String osFamily = random.pickOne(OS_FAMILIES);
		String os = random.pickOne(OS_NAMES_BY_FAMILY.get(osFamily));
		return Pair.of(os, osFamily);
	}

	public static List<String> generateOSNames(final RandomGenerator random, final int count, final OsNames names) {
		checkNotNull(random, "Precondition violation - argument 'random' must not be NULL!");
		checkArgument(count > 0, "Precondition violation - argument 'count' must not be negative!");
		checkNotNull(names, "Precondition violation - argument 'names' must not be NULL!");
		switch (names) {
		case RANDOM:
			return random.pick(OS_NAMES, count, false);
		case SAME_FAMILY:
			String osFamily = random.pickOne(OS_FAMILIES);
			List<String> osList = OS_NAMES_BY_FAMILY.get(osFamily);
			return random.pick(osList, count, false);
		case SAME_OS:
			String singleOsFamily = random.pickOne(OS_FAMILIES);
			return Lists.newArrayList(random.pickOne(OS_NAMES_BY_FAMILY.get(singleOsFamily)));
		default:
			throw new RuntimeException("Unknown literal of " + OsNames.class.getName() + ": '" + names + "'!");
		}
	}

	public static String getCommonOSFamily(final String os1, final String os2) {
		String regex = "(.*)\\s+[0-9]+(\\.[0-9]*)?";
		Pattern osNamePattern = Pattern.compile(regex);
		if (os1.equals(os2)) {
			return os1;
		}
		String commonSubstring = longestCommonSubstring(os1, os2).trim();
		if (commonSubstring.isEmpty()) {
			return "";
		}
		if (os1.startsWith(commonSubstring) == false || os2.startsWith(commonSubstring) == false) {
			return "";
		}
		Matcher matcher = osNamePattern.matcher(commonSubstring);
		if (matcher.matches()) {
			// remove version number postfix
			commonSubstring = matcher.group(1);
		}
		return commonSubstring;
	}

	public static Function<String, String> createUsageAppender(final Map<String, Object> mutatorState) {
		checkNotNull(mutatorState, "Precondition violation - argument 'mutatorState' must not be NULL!");
		return (name) -> {
			String key = MUTATOR_STATE_NAME_USAGE_PREFIX + "." + name;
			Integer usage = (Integer) mutatorState.get(key);
			int count = usage == null ? 1 : usage;
			String newName = name + " " + count;
			count++;
			mutatorState.put(key, count);
			return newName;
		};
	}

	private static String longestCommonSubstring(final String a, final String b) {
		int Start = 0;
		int Max = 0;
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				int x = 0;
				while (a.charAt(i + x) == b.charAt(j + x)) {
					x++;
					if (i + x >= a.length() || j + x >= b.length()) {
						break;
					}
				}
				if (x > Max) {
					Max = x;
					Start = i;
				}
			}
		}
		return a.substring(Start, Start + Max);
	}

	public static enum OsNames {

		RANDOM, SAME_FAMILY, SAME_OS

	}

	public static String generateIpAdress(final RandomGenerator random) {
		String separator = "";
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			builder.append(separator);
			separator = ".";
			builder.append(random.nextIntBetween(1, 254));
		}
		return builder.toString();
	}

}
