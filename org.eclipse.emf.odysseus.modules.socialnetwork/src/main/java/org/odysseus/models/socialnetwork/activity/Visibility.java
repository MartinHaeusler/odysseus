/**
 */
package org.odysseus.models.socialnetwork.activity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Visibility</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getVisibility()
 * @model
 * @generated
 */
public enum Visibility implements Enumerator {
	/**
	 * The '<em><b>Everyone</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EVERYONE_VALUE
	 * @generated
	 * @ordered
	 */
	EVERYONE(1, "Everyone", "EVERYONE"),

	/**
	 * The '<em><b>Friends Of Friends</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRIENDS_OF_FRIENDS_VALUE
	 * @generated
	 * @ordered
	 */
	FRIENDS_OF_FRIENDS(2, "FriendsOfFriends", "FRIENDSOFFRIENDS"),

	/**
	 * The '<em><b>Friends</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRIENDS_VALUE
	 * @generated
	 * @ordered
	 */
	FRIENDS(3, "Friends", "FRIENDS"),

	/**
	 * The '<em><b>Just Me</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JUST_ME_VALUE
	 * @generated
	 * @ordered
	 */
	JUST_ME(4, "JustMe", "JUSTME");

	/**
	 * The '<em><b>Everyone</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Everyone</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EVERYONE
	 * @model name="Everyone" literal="EVERYONE"
	 * @generated
	 * @ordered
	 */
	public static final int EVERYONE_VALUE = 1;

	/**
	 * The '<em><b>Friends Of Friends</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Friends Of Friends</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FRIENDS_OF_FRIENDS
	 * @model name="FriendsOfFriends" literal="FRIENDSOFFRIENDS"
	 * @generated
	 * @ordered
	 */
	public static final int FRIENDS_OF_FRIENDS_VALUE = 2;

	/**
	 * The '<em><b>Friends</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Friends</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FRIENDS
	 * @model name="Friends" literal="FRIENDS"
	 * @generated
	 * @ordered
	 */
	public static final int FRIENDS_VALUE = 3;

	/**
	 * The '<em><b>Just Me</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Just Me</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JUST_ME
	 * @model name="JustMe" literal="JUSTME"
	 * @generated
	 * @ordered
	 */
	public static final int JUST_ME_VALUE = 4;

	/**
	 * An array of all the '<em><b>Visibility</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Visibility[] VALUES_ARRAY =
		new Visibility[] {
			EVERYONE,
			FRIENDS_OF_FRIENDS,
			FRIENDS,
			JUST_ME,
		};

	/**
	 * A public read-only list of all the '<em><b>Visibility</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Visibility> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Visibility</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Visibility get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Visibility result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Visibility</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Visibility getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Visibility result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Visibility</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Visibility get(int value) {
		switch (value) {
			case EVERYONE_VALUE: return EVERYONE;
			case FRIENDS_OF_FRIENDS_VALUE: return FRIENDS_OF_FRIENDS;
			case FRIENDS_VALUE: return FRIENDS;
			case JUST_ME_VALUE: return JUST_ME;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Visibility(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Visibility
