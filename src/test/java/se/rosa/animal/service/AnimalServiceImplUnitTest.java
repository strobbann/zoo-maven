package se.rosa.animal.service;

import org.junit.Test;
import se.rosa.animal.dao.AnimalDao;
import se.rosa.animal.dao.AnimalDaoImpl;
import se.rosa.animal.domain.Animal;
import se.rosa.logging.LoggerConsoleStandard;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class AnimalServiceImplUnitTest {

	@Test
	public void testNamesOfAllAnimals() {
		AnimalDao animalDao = new AnimalDaoImpl();
		AnimalService animalService = new AnimalServiceImpl(animalDao, new LoggerConsoleStandard());
		animalDao.create(Animal.builder().withId(1L).withName("JUNIT").build());
		assertTrue(animalService.getNamesOfAllAnimals().contains("JUNIT"));
	}

	@Test
	public void testGetAllAnimalTypes() {
		AnimalDao animalDao = new AnimalDaoImpl();
		AnimalService animalService = new AnimalServiceImpl(animalDao, new LoggerConsoleStandard());
		animalDao.create(Animal.builder().withId(1L).withName("JUNIT").withType(Animal.AnimalType.UNSPECIFIED).build());
		animalDao.create(Animal.builder().withId(2L).withName("JUNIT").withType(Animal.AnimalType.CAT).build());
		animalDao.create(Animal.builder().withId(3L).withName("JUNIT").withType(Animal.AnimalType.DOG).build());
		assertEquals(true, animalService.getAllAnimalTypes().contains(Animal.AnimalType.CAT));
	}
}
