package org.odysseus.internal.configuration;

import static com.google.common.base.Preconditions.*;

import java.util.Collections;
import java.util.Set;

import com.google.common.collect.Sets;

public enum FeatureAccessMode {

	/** */
	VIA_GENERATED_GETTERS_AND_SETTERS("getterssetters", "gettersetter", "getset", "generated"),

	/** */
	VIA_REFLECTIVE_API("reflective", "reflection", "eget", "egeteset", "eset");

	// =====================================================================================================================
	// FIELDS
	// =====================================================================================================================

	/** The primary name for this mode. */
	private final String primaryName;
	/** A set of aliases (alternative names) for this mode. */
	private final Set<String> aliases;
	/** The set of all possible names for this mode. The union of {@link #primaryName} and {@link #aliases}. */
	private final Set<String> allNames;

	private FeatureAccessMode(final String primaryName, final String... aliases) {
		checkNotNull(primaryName, "Precondition violation - argument 'primaryName' must not be NULL!");
		this.primaryName = primaryName;
		Set<String> myAliases = Sets.newHashSet();
		if (aliases != null && aliases.length > 0) {
			for (String alias : aliases) {
				myAliases.add(alias);
			}
		}
		this.aliases = Collections.unmodifiableSet(myAliases);
		Set<String> myNames = Sets.newHashSet();
		myNames.add(primaryName);
		myNames.addAll(this.aliases);
		this.allNames = Collections.unmodifiableSet(myNames);
	}

	@Override
	public String toString() {
		return this.primaryName;
	}

	/**
	 * This method parses a string value into a {@link FeatureAccessMode}.
	 *
	 * <p>
	 * This method takes all aliases into account and is therefore more fault tolerant than the default
	 * {@link #valueOf(String)} method.
	 *
	 * @param stringValue
	 *            The string value to parse. Must not be <code>null</code>.
	 * @return The EObjectFeatureAccessMode described in the string. Never <code>null</code>.
	 *
	 * @throws IllegalArgumentException
	 *             Thrown if the parsing process failed.
	 */
	public static FeatureAccessMode fromString(final String stringValue) {
		checkNotNull(stringValue, "Precondition violation - argument 'stringValue' must not be NULL!");
		String token = stringValue.toLowerCase().trim();
		if (token.isEmpty()) {
			throw new IllegalArgumentException("Cannot parse DuplicateVersionEliminationMode from empty string!");
		}
		for (FeatureAccessMode mode : FeatureAccessMode.values()) {
			for (String name : mode.allNames) {
				if (name.equalsIgnoreCase(token)) {
					return mode;
				}
			}
		}
		throw new IllegalArgumentException("Unknown ChronosBackend: '" + token + "'!");
	}

}
