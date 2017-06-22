package org.odysseus.test.edpl;

import static com.google.common.base.Preconditions.*;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.odysseus.internal.util.EMFUtils;

public class OdysseusTestUtils {

	public static EPackage createDynamicDeepCopyOf(final EPackage original) {
		checkNotNull(original, "Precondition violation - argument 'original' must not be NULL!");
		EPackage copy = EcoreUtil.copy(original);
		// for each EClass in our copied EPackage, erase the classifier info
		EMFUtils.flattenEPackage(copy).forEach(pack -> pack.getEClassifiers().forEach(eClass -> {
			eClass.setInstanceClass(null);
			eClass.setInstanceClassName(null);
			eClass.setInstanceTypeName(null);
		}));
		return copy;
	}

}
