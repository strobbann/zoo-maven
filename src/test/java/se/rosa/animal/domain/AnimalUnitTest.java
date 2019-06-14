package se.rosa.animal.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Robert on 2019-06-04.
 */
public class AnimalUnitTest {

	@Test
	public void buildAnimal() {
		Animal animal = Animal.builder().withId(1L).withName("JUNIT").build();
		assertEquals(Long.valueOf(1L), animal.getId());
		assertEquals("JUNIT", animal.getName());
	}
}
