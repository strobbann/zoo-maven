package se.rosa.dao;

import se.rosa.domain.Animal;
import se.rosa.logging.Logger;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * Created by Robert on 2019-06-04.
 */

public class AnimalDaoImpl implements AnimalDao {

	private HashMap<Long, Animal> animals;
	private Logger logger;

	public AnimalDaoImpl() {
		animals = new HashMap<>();
	}

	public void setLogger(Logger logger) {
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
	public Animal get(Long id) {
		return animalChecker(animals.get(id));
	}

	@Override
	public void update(Animal animal) {
		animalChecker(animals.get(animal.getId()), () -> animals.put(animal.getId(), animal));
	}

	@Override
	public void delete(Long id) {
		animalChecker(animals.get(id), () -> animals.remove(id));
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
		Optional.ofNullable(animal).orElseThrow(() -> new IllegalArgumentException("Animal is null"));
		return supplier.get();
	}

	public Animal animalChecker(Animal animal) {
		return Optional.ofNullable(animal).orElseThrow(() -> new IllegalArgumentException("Animal is null"));
	}

	public Animal searchByReturnSingle(Predicate<Animal> predicate) {
		return animals.values().stream()
				.filter(predicate)
				.findFirst()
				.map(a -> a)
				.orElseThrow(() -> new IllegalArgumentException("Animal is null"));
	}

	public List<Animal> searchByReturnList(Predicate<Animal> predicate) {
		return animals.values().stream()
				.filter(predicate)
				.collect(Collectors.toList());
	}


}
