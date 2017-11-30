/**
 */
package org.odysseus.modules.itlandscape;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Service Level Agreement</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getServiceLevelAgreement()
 * @model
 * @generated
 */
public enum ServiceLevelAgreement implements Enumerator {
	/**
	 * The '<em><b>BEST EFFORT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BEST_EFFORT_VALUE
	 * @generated
	 * @ordered
	 */
	BEST_EFFORT(0, "BEST_EFFORT", "BEST_EFFORT"),

	/**
	 * The '<em><b>BRONZE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRONZE_VALUE
	 * @generated
	 * @ordered
	 */
	BRONZE(1, "BRONZE", "BRONZE"),

	/**
	 * The '<em><b>SILVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SILVER_VALUE
	 * @generated
	 * @ordered
	 */
	SILVER(2, "SILVER", "SILVER"),

	/**
	 * The '<em><b>GOLD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GOLD_VALUE
	 * @generated
	 * @ordered
	 */
	GOLD(3, "GOLD", "GOLD");

	/**
	 * The '<em><b>BEST EFFORT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BEST EFFORT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BEST_EFFORT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BEST_EFFORT_VALUE = 0;

	/**
	 * The '<em><b>BRONZE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BRONZE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BRONZE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BRONZE_VALUE = 1;

	/**
	 * The '<em><b>SILVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SILVER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SILVER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SILVER_VALUE = 2;

	/**
	 * The '<em><b>GOLD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GOLD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GOLD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GOLD_VALUE = 3;

	/**
	 * An array of all the '<em><b>Service Level Agreement</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ServiceLevelAgreement[] VALUES_ARRAY = new ServiceLevelAgreement[] { BEST_EFFORT, BRONZE,
			SILVER, GOLD, };

	/**
	 * A public read-only list of all the '<em><b>Service Level Agreement</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ServiceLevelAgreement> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Service Level Agreement</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ServiceLevelAgreement get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServiceLevelAgreement result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Service Level Agreement</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ServiceLevelAgreement getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServiceLevelAgreement result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Service Level Agreement</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ServiceLevelAgreement get(int value) {
		switch (value) {
		case BEST_EFFORT_VALUE:
			return BEST_EFFORT;
		case BRONZE_VALUE:
			return BRONZE;
		case SILVER_VALUE:
			return SILVER;
		case GOLD_VALUE:
			return GOLD;
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
	private ServiceLevelAgreement(int value, String name, String literal) {
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

} //ServiceLevelAgreement
