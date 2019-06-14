package se.rosa.animal.service;


import se.rosa.animal.domain.Animal;

import java.util.List;

public interface AnimalService {

	List<String> getNamesOfAllAnimals();

	List<Animal.AnimalType> getAllAnimalTypes();

}
