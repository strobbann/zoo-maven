package se.rosa.dao;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import se.rosa.domain.Animal;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Robert on 2019-06-04.
 */
public class AnimalDaoUnitTest {
	private AnimalDao animalDao;

	@Before
	public void before() {
		animalDao = mock(AnimalDao.class);
	}

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Test
	public void testCreateGet() {
		Animal animal = Animal.builder().withId(1L).withName("JUNIT").build();
		doNothing().when(animalDao).create(isA(Animal.class));
		animalDao.create(animal);
		verify(animalDao, times(1)).create(animal);
	}

	@Test
	public void testDelete() {
		Animal animal = Animal.builder().withId(1L).withName("JUNIT").build();
		ex.expect(IllegalArgumentException.class);
		ex.expectMessage("Animal is null");
		doNothing().when(animalDao).create(isA(Animal.class));
		animalDao.create(animal);
		verify(animalDao, times(1)).create(animal);

		doNothing().when(animalDao).delete(isA(Long.class));
		animalDao.delete(animal.getId());
		verify(animalDao, times(1)).delete(animal.getId());

		doThrow(new IllegalArgumentException("Animal is null"))
				.when(animalDao.get(isA(Long.class)));

		animalDao.get(animal.getId());
		/*
		AnimalDao animalDao = new AnimalDaoImpl();
		animalDao.create(Animal.builder().withId(1L).withName("JUNIT").build());
		animalDao.delete(1L);
		animalDao.get(1L);*/
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

	@Test
	public void testFindAnimalsByType() {
		AnimalDao animalDao = new AnimalDaoImpl();
		Animal animal = Animal.builder().withId(1L).withName("JUNIT").withType(Animal.AnimalType.DOG).build();
		Animal animal2 = Animal.builder().withId(2L).withName("JUNIT2").withType(Animal.AnimalType.DOG).build();
		animalDao.create(animal);
		animalDao.create(animal2);
		animalDao.create(Animal.builder().withId(3L).withName("JUNIT3").withType(Animal.AnimalType.BIRD).build());
		assertTrue(animalDao.findAnimalsByType(Animal.AnimalType.DOG).containsAll(Arrays.asList(animal, animal2)));
	}

	@Test
	public void testGetAll() {
		AnimalDao animalDao = new AnimalDaoImpl();
		Animal animal = Animal.builder().withId(1L).withName("JUNIT").build();
		Animal animal2 = Animal.builder().withId(2L).withName("JUNIT2").build();
		animalDao.create(animal);
		animalDao.create(animal2);
		animalDao.create(Animal.builder().withId(3L).withName("JUNIT3").build());
		assertTrue(animalDao.getAll().containsAll(Arrays.asList(animal, animal2)));
	}
}
