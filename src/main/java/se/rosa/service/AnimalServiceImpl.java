package se.rosa.service;

import se.rosa.dao.AnimalDao;
import se.rosa.domain.Animal;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AnimalServiceImpl implements AnimalService {

	private AnimalDao animalDao;

	public AnimalServiceImpl(AnimalDao animalDao) {
		this.animalDao = Objects.requireNonNull(animalDao, "animalDao cannot be null");
	}

	@Override
	public List<String> getNamesOfAllAnimals() {
		return animalDao.getAll().stream().map(Animal::getName).collect(Collectors.toList());
	}

	@Override
	public List<Animal.AnimalType> getAllAnimalTypes() {
		return animalDao.getAll().stream().map(Animal::getType).distinct().collect(Collectors.toList());
	}
}
