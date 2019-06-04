package se.rosa.dao;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import se.rosa.domain.Animal;

import static org.junit.Assert.*;

/**
 * Created by Robert on 2019-06-04.
 */
public class AnimalDaoUnitTest {
	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Test
	public void testCreateGet() {
		AnimalDao animalDao = new AnimalDaoImpl();
		animalDao.create(Animal.builder().withId(1L).withName("JUNIT").build());
		assertNotNull(animalDao.get(1L));
	}

	@Test
	public void testDelete() {
		ex.expect(IllegalArgumentException.class);
		ex.expectMessage("Animal is null");
		AnimalDao animalDao = new AnimalDaoImpl();
		animalDao.create(Animal.builder().withId(1L).withName("JUNIT").build());
		animalDao.delete(1L);
		animalDao.get(1L);
	}

	@Test
	public void testUpdate() {
		AnimalDao animalDao = new AnimalDaoImpl();
		Animal animal = Animal.builder().withId(1L).withName("JUNIT").withType(Animal.AnimalType.DOG).build();
		animalDao.create(animal);
		assertEquals(animal.getType(), animalDao.get(1L).getType());
		Animal updateAnimal = Animal.builder().withId(animal.getId()).withName(animal.getName()).withType(Animal.AnimalType.CAT).build();
		animalDao.update(updateAnimal);
		assertNotEquals(animal.getType(), animalDao.get(1L).getType());
	}

	@Test
	public void testFindAnimalByName() {
		AnimalDao animalDao = new AnimalDaoImpl();
		Animal animal = Animal.builder().withName("JUNIT").withId(1L).build();
		animalDao.create(animal);
		assertEquals(animal.getName(), animalDao.findAnimalByName("JUNIT").getName());
	}

	@Test
	public void testFindAnimalsByName() {
		AnimalDao animalDao = new AnimalDaoImpl();
		Animal a = Animal.builder().withId(1L).withName("JUNIT").build();
		animalDao.create(a);
		animalDao.create(Animal.builder().withId(2L).withName("JUNIT2").build());
		animalDao.create(Animal.builder().withId(3L).withName("JUNIT3").build());
		assertTrue(animalDao.findAnimalsByName("JUNIT").contains(a));
		
	}
}
