package org.odysseus.modules.socialnetwork.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.odysseus.models.socialnetwork.user.Group;
import org.odysseus.models.socialnetwork.user.Person;
import org.odysseus.models.socialnetwork.user.UserFactory;

public class SocialNetworkModelTest {

	@Test
	public void eOppositesWork() {
		Group groupA = UserFactory.eINSTANCE.createGroup();
		groupA.setName("GroupA");
		Group groupB = UserFactory.eINSTANCE.createGroup();
		groupB.setName("GroupB");
		Person john = UserFactory.eINSTANCE.createPerson();
		john.setFirstName("John");
		Person jack = UserFactory.eINSTANCE.createPerson();
		jack.setFirstName("Jack");
		Person jane = UserFactory.eINSTANCE.createPerson();
		jane.setFirstName("Jane");
		groupA.getMembers().add(john);
		groupA.getMembers().add(jane);
		groupB.getMembers().add(jane);
		groupB.getMembers().add(jack);
		assertTrue(john.getMembershipInGroups().contains(groupA));
		assertFalse(john.getMembershipInGroups().contains(groupB));
		assertTrue(jane.getMembershipInGroups().contains(groupA));
		assertTrue(jane.getMembershipInGroups().contains(groupB));
		assertFalse(jack.getMembershipInGroups().contains(groupA));
		assertTrue(jack.getMembershipInGroups().contains(groupB));

		john.setMarriedTo(jane);
		jane.setMarriedTo(john);
		john.getChildren().add(jack);
		jane.getChildren().add(jack);
		assertTrue(jack.getParents().contains(john));
		assertTrue(jack.getParents().contains(jane));
	}
}
