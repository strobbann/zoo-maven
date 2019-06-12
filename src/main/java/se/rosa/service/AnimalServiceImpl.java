package se.rosa.service;

import se.rosa.dao.AnimalDao;
import se.rosa.domain.Animal;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AnimalServiceImpl implements AnimalService {

	private AnimalDao animalDao;

	public AnimalServiceImpl(AnimalDao animalDao) {
		this.animalDao = animalDao;
	}

	@Override
	public List<String> namesOfAllAnimals() {
		return animalDao.getAll().stream().map(Animal::getName).collect(Collectors.toList());
	}
}
