package se.rosa.dao;

import se.rosa.domain.Animal;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * Created by Robert on 2019-06-04.
 */

public class AnimalDaoImpl implements AnimalDao {

	private HashMap<Long, Animal> animals;

	public AnimalDaoImpl() {
		animals = new HashMap<>();
	}

	@Override
	public void create(Animal animal) {
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

	public void animalChecker(Animal animal, Consumer<Animal> consumer) {
		Animal a = Optional.ofNullable(animal).orElseThrow(() -> new IllegalArgumentException("Animal is null"));
		consumer.accept(animal);
	}

	public Animal animalChecker(Animal animal, Supplier<Animal> supplier) {
		Animal a = Optional.ofNullable(animal).orElseThrow(() -> new IllegalArgumentException("Animal is null"));
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
