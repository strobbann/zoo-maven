package se.rosa.animal.service;

import se.rosa.animal.dao.AnimalDao;
import se.rosa.animal.domain.Animal;
import se.rosa.logging.Logger;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AnimalServiceImpl implements AnimalService {

	private AnimalDao animalDao;
	private Logger<AnimalServiceImpl> logger;

	public AnimalServiceImpl(AnimalDao animalDao, Logger<AnimalServiceImpl> logger) {
		this.animalDao = Objects.requireNonNull(animalDao, "animalDao cannot be null");
		this.logger = Objects.requireNonNull(logger);
	}

	public void log(String message) {
		logger.log(message,this);
	}

	@Override
	public List<String> getNamesOfAllAnimals() {
		log("on getNamesOfAllAnimals");
		return animalDao.getAll().stream().map(Animal::getName).collect(Collectors.toList());
	}

	@Override
	public List<Animal.AnimalType> getAllAnimalTypes() {
		log("on getAllAnimalTypes");
		return animalDao.getAll().stream().map(Animal::getType).distinct().collect(Collectors.toList());
	}
}
