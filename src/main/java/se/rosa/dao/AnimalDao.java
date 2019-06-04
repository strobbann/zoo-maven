package se.rosa.dao;

import se.rosa.domain.Animal;

import java.util.List;

/**
 * Created by Robert on 2019-06-04.
 */
public interface AnimalDao {

	void create(Animal animal);

	Animal get(Long id);

	void update(Animal animal);

	void delete(Long id);

	Animal findAnimalByName(String name);

	List<Animal> findAnimalsByName(String name);

	List<Animal> findAnimalsByType(Animal.AnimalType animalType);

	List<Animal> getAll();
}
