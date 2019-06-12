package se.rosa.service;

import se.rosa.domain.Animal;

import java.util.List;

public interface AnimalService {

	List<String> getNamesOfAllAnimals();

	List<Animal.AnimalType> getAllAnimalTypes();

}
