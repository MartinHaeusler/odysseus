/**
 */
package org.odysseus.models.socialnetwork.activity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Reaction Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getReactionType()
 * @model
 * @generated
 */
public enum ReactionType implements Enumerator {
	/**
	 * The '<em><b>Like</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIKE_VALUE
	 * @generated
	 * @ordered
	 */
	LIKE(1, "Like", "LIKE"),

	/**
	 * The '<em><b>Haha</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HAHA_VALUE
	 * @generated
	 * @ordered
	 */
	HAHA(2, "Haha", "HAHA"),

	/**
	 * The '<em><b>Angry</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANGRY_VALUE
	 * @generated
	 * @ordered
	 */
	ANGRY(3, "Angry", "ANGRY"),

	/**
	 * The '<em><b>Sad</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SAD_VALUE
	 * @generated
	 * @ordered
	 */
	SAD(4, "Sad", "SAD"),

	/**
	 * The '<em><b>Wow</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WOW_VALUE
	 * @generated
	 * @ordered
	 */
	WOW(5, "Wow", "WOW"),

	/**
	 * The '<em><b>Love</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOVE_VALUE
	 * @generated
	 * @ordered
	 */
	LOVE(6, "Love", "LOVE");

	/**
	 * The '<em><b>Like</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Like</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIKE
	 * @model name="Like" literal="LIKE"
	 * @generated
	 * @ordered
	 */
	public static final int LIKE_VALUE = 1;

	/**
	 * The '<em><b>Haha</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Haha</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HAHA
	 * @model name="Haha" literal="HAHA"
	 * @generated
	 * @ordered
	 */
	public static final int HAHA_VALUE = 2;

	/**
	 * The '<em><b>Angry</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Angry</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANGRY
	 * @model name="Angry" literal="ANGRY"
	 * @generated
	 * @ordered
	 */
	public static final int ANGRY_VALUE = 3;

	/**
	 * The '<em><b>Sad</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sad</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SAD
	 * @model name="Sad" literal="SAD"
	 * @generated
	 * @ordered
	 */
	public static final int SAD_VALUE = 4;

	/**
	 * The '<em><b>Wow</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Wow</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WOW
	 * @model name="Wow" literal="WOW"
	 * @generated
	 * @ordered
	 */
	public static final int WOW_VALUE = 5;

	/**
	 * The '<em><b>Love</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Love</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOVE
	 * @model name="Love" literal="LOVE"
	 * @generated
	 * @ordered
	 */
	public static final int LOVE_VALUE = 6;

	/**
	 * An array of all the '<em><b>Reaction Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ReactionType[] VALUES_ARRAY =
		new ReactionType[] {
			LIKE,
			HAHA,
			ANGRY,
			SAD,
			WOW,
			LOVE,
		};

	/**
	 * A public read-only list of all the '<em><b>Reaction Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ReactionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Reaction Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ReactionType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReactionType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Reaction Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ReactionType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReactionType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Reaction Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ReactionType get(int value) {
		switch (value) {
			case LIKE_VALUE: return LIKE;
			case HAHA_VALUE: return HAHA;
			case ANGRY_VALUE: return ANGRY;
			case SAD_VALUE: return SAD;
			case WOW_VALUE: return WOW;
			case LOVE_VALUE: return LOVE;
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
	private ReactionType(int value, String name, String literal) {
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
	
} //ReactionType
