package se.rosa.animal.dao;

import se.rosa.animal.domain.Animal;
import se.rosa.logging.Logger;

import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by Robert on 2019-06-04.
 */

public class AnimalDaoImpl implements AnimalDao {

	private HashMap<Long, Animal> animals;
	private Logger<AnimalDaoImpl> logger;

	public AnimalDaoImpl() {
		animals = new HashMap<>();
	}

	public void setLogger(Logger<AnimalDaoImpl> logger) {
		this.logger = logger;
	}

	public void log(String message) {
		if (logger != null) {
			logger.log(message, this);
		}
	}

	@Override
	public void create(Animal animal) {
		log("on create");
		animalChecker(animal, () -> animals.put(animal.getId(), animal));
	}

	@Override
	public Animal read(Long id) {
		log("on read");
		return animalChecker(animals.get(id));
	}

	@Override
	public Animal update(Animal animal) {
		return animalChecker(animals.get(animal.getId()), () -> animals.put(animal.getId(), animal));
	}

	@Override
	public Animal delete(Long id) {
		return animalChecker(animals.get(id), () -> animals.remove(id));
	}

	@Override
	public Animal findAnimalByName(String name) {
		Objects.requireNonNull(name, "Search name cannot be null");
		return searchByReturnSingle(animal -> animal.getName().equals(name));
	}

	@Override
	public List<Animal> findAnimalsByName(String name) {
		return searchByReturnList(animal -> animal.getName().equals(name));
	}

	@Override
	public List<Animal> findAnimalsByType(Animal.AnimalType animalType) {
		return searchByReturnList(animal -> animal.getType().equals(animalType));
	}

	@Override
	public List<Animal> getAll() {
		return new ArrayList<>(animals.values());
	}

	public Animal animalChecker(Animal animal, Supplier<Animal> supplier) {
		Optional.ofNullable(animal).orElseThrow(() -> new IllegalArgumentException("Animal does not exist"));
		return supplier.get();
	}

	public Animal animalChecker(Animal animal) {
		return Optional.ofNullable(animal).orElseThrow(() -> new IllegalArgumentException("Animal does not exist"));
	}

	public Animal searchByReturnSingle(Predicate<Animal> predicate) {
		return animals.values().stream()
				.filter(predicate)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Animal cannot be found"));
	}

	public List<Animal> searchByReturnList(Predicate<Animal> predicate) {
		return animals.values().stream()
				.filter(predicate)
				.collect(Collectors.toList());
	}


}
