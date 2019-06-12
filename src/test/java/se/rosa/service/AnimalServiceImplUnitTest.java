package se.rosa.service;

import org.junit.Test;
import se.rosa.dao.AnimalDao;
import se.rosa.dao.AnimalDaoImpl;
import se.rosa.domain.Animal;

import static junit.framework.TestCase.assertTrue;

public class AnimalServiceImplUnitTest {

	@Test
	public void testNamesOfAllAnimals() {
		AnimalDao animalDao = new AnimalDaoImpl();
		AnimalService animalService = new AnimalServiceImpl(animalDao);
		animalDao.create(Animal.builder().withId(1L).withName("JUNIT").build());
		assertTrue(animalService.namesOfAllAnimals().contains("JUNIT"));
	}

	@Test
	public void testGetAllAnimalTypes() {

	}
}
