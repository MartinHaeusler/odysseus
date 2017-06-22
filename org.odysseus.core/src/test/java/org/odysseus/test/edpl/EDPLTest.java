package org.odysseus.test.edpl;

import static org.junit.Assert.*;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.odysseus.models.socialnetwork.user.Person;
import org.odysseus.models.socialnetwork.user.UserPackage;
import org.junit.Test;
import org.odysseus.internal.OdysseusEPackageRegistry;
import org.odysseus.internal.configuration.FeatureAccessMode;
import org.odysseus.internal.edpl.EDPLProxy;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class EDPLTest {

	@Test
	public void canCreateEDPLProxy() {
		EObject eObject = EcoreFactory.eINSTANCE.createEObject();
		EObject proxy = EDPLProxy.createReflective(eObject, EObject.class);
		assertNotNull(proxy);
	}

	@Test
	public void canRecognizeEDPLProxies() {
		EObject eObject = EcoreFactory.eINSTANCE.createEObject();
		EObject proxy = EDPLProxy.createReflective(eObject, EObject.class);
		assertNotNull(proxy);
		assertTrue(EDPLProxy.isEDPLProxy(proxy));
		assertFalse(EDPLProxy.isEDPLProxy(eObject));
	}

	@Test
	public void canUnwrapEDPLProxy() {
		EObject eObject = EcoreFactory.eINSTANCE.createEObject();
		EObject proxy = EDPLProxy.createReflective(eObject, EObject.class);
		assertNotNull(proxy);
		assertTrue(eObject == EDPLProxy.unwrap(proxy));
		assertTrue(eObject == EDPLProxy.unwrap(eObject));
		assertFalse(EDPLProxy.isEDPLProxy(EDPLProxy.unwrap(proxy)));
	}

	@Test
	public void edplProxiesAreNotWrappedMoreThanOnce() {
		EObject eObject = EcoreFactory.eINSTANCE.createEObject();
		EObject proxy = EDPLProxy.createReflective(eObject, EObject.class);
		assertNotNull(proxy);
		assertTrue(proxy == EDPLProxy.createReflective(proxy, EObject.class));
	}

	@Test
	public void equalsModuloProxyWorksInBothDirections() {
		EObject eObject = EcoreFactory.eINSTANCE.createEObject();
		EObject proxy = EDPLProxy.createReflective(eObject, EObject.class);
		assertTrue(EDPLProxy.equalsModuloProxy(eObject, proxy));
		assertTrue(EDPLProxy.equalsModuloProxy(proxy, eObject));
	}

	@Test
	public void equalsModuloProxyWorksOnPlainEObjects() {
		EObject eObject = EcoreFactory.eINSTANCE.createEObject();
		assertTrue(EDPLProxy.equalsModuloProxy(eObject, eObject));
		assertTrue(EDPLProxy.equalsModuloProxy(eObject, eObject));
	}

	@Test
	public void equalsModuloProxyWorksWithTwoProxies() {
		EObject eObject = EcoreFactory.eINSTANCE.createEObject();
		EObject proxyA = EDPLProxy.createReflective(eObject, EObject.class);
		EObject proxyB = EDPLProxy.createReflective(eObject, EObject.class);
		assertTrue(EDPLProxy.equalsModuloProxy(proxyB, proxyA));
		assertTrue(EDPLProxy.equalsModuloProxy(proxyA, proxyB));
	}

	@Test
	public void twoProxiesOfSameEObjectAreEqual() {
		EObject eObject = EcoreFactory.eINSTANCE.createEObject();
		EObject proxyA = EDPLProxy.createReflective(eObject, EObject.class);
		EObject proxyB = EDPLProxy.createReflective(eObject, EObject.class);
		assertTrue(proxyA.equals(proxyB));
		assertTrue(proxyB.equals(proxyA));
	}

	@Test
	public void canAccessEAttributeViaGeneratedInterfaceOverDynamicEMF() {
		OdysseusEPackageRegistry.eINSTANCE.ensureEPackageIsRegistered(UserPackage.eINSTANCE);
		// mock the "client" EPackage
		EPackage ePackage = OdysseusTestUtils.createDynamicDeepCopyOf(UserPackage.eINSTANCE);
		EClass ecPerson = (EClass) ePackage.getEClassifier("Person");
		EAttribute eaFirstName = (EAttribute) ecPerson.getEStructuralFeature("firstName");
		assertNotNull(eaFirstName);

		// mock the "client" EObject....
		EObject user1 = EcoreUtil.create(ecPerson);
		// ... which is NOT an instance of the generated model used by Odysseus
		assertFalse(user1 instanceof Person);

		// create the Ecore Dynamic Proxy Layer for the EObject, "pretending" that it is an instance
		// of our internal interface
		Person user = EDPLProxy.create(user1, Person.class, FeatureAccessMode.VIA_REFLECTIVE_API);
		// call a feature setter and getter on it
		user.setFirstName("John");
		assertEquals("John", user.getFirstName());

		// make sure that the "client" code can see the changes made through EDPL
		assertEquals("John", user1.eGet(eaFirstName));
	}

	@Test
	public void canAccessMultiplicityOneEReferenceViaGeneratedInterfaceOverDynamicEMF() {
		OdysseusEPackageRegistry.eINSTANCE.ensureEPackageIsRegistered(UserPackage.eINSTANCE);
		// mock the "client" EPackage
		EPackage ePackage = OdysseusTestUtils.createDynamicDeepCopyOf(UserPackage.eINSTANCE);
		EClass ecPerson = (EClass) ePackage.getEClassifier("Person");
		EReference erMarriedTo = (EReference) ecPerson.getEStructuralFeature("marriedTo");
		EAttribute eaFirstName = (EAttribute) ecPerson.getEStructuralFeature("firstName");
		assertNotNull(erMarriedTo);
		assertNotNull(eaFirstName);

		// mock the "client" EObjects
		EObject user1 = EcoreUtil.create(ecPerson);
		user1.eSet(eaFirstName, "John");
		EObject user2 = EcoreUtil.create(ecPerson);
		user2.eSet(eaFirstName, "Jane");

		user1.eSet(erMarriedTo, user2);

		// create the proxy
		Person john = EDPLProxy.createReflective(user1, Person.class);
		Person jane = john.getMarriedTo();
		assertNull(jane.getMarriedTo());
		jane.setMarriedTo(john);
		assertEquals(john, jane.getMarriedTo());

		// make sure that the changes are visible on the client side
		assertEquals(user2, user1.eGet(erMarriedTo));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void canAccessMultiplicityManyEReferenceViaGeneratedInterfaceOverDynamicEMF() {
		OdysseusEPackageRegistry.eINSTANCE.ensureEPackageIsRegistered(UserPackage.eINSTANCE);
		// mock the "client" EPackage
		EPackage ePackage = OdysseusTestUtils.createDynamicDeepCopyOf(UserPackage.eINSTANCE);
		EClass ecPerson = (EClass) ePackage.getEClassifier("Person");
		EReference erFriends = (EReference) ecPerson.getEStructuralFeature("friends");
		EAttribute eaFirstName = (EAttribute) ecPerson.getEStructuralFeature("firstName");
		assertNotNull(erFriends);
		assertNotNull(eaFirstName);

		// mock the "client" EObjects
		EObject user1 = EcoreUtil.create(ecPerson);
		user1.eSet(eaFirstName, "John");
		EObject user2 = EcoreUtil.create(ecPerson);
		user2.eSet(eaFirstName, "Jack");
		EObject user3 = EcoreUtil.create(ecPerson);
		user3.eSet(eaFirstName, "Jane");

		// create the relationship on the client side
		((Collection<EObject>) user1.eGet(erFriends)).add(user2);

		// create the proxy layer
		Person john = EDPLProxy.create(user1, Person.class, FeatureAccessMode.VIA_REFLECTIVE_API);
		// call the getter
		EList<Person> friends = john.getFriends();
		assertEquals(1, friends.size());
		assertEquals("Jack", Iterables.getOnlyElement(friends).getFirstName());

		Person jane = EDPLProxy.create(user3, Person.class, FeatureAccessMode.VIA_REFLECTIVE_API);
		friends.add(jane);
		assertTrue(john.getFriends().contains(jane));

		// check that the new reference was created on the client side
		assertEquals(Lists.newArrayList(user2, user3), user1.eGet(erFriends));
	}
}
