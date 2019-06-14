package se.rosa.animal.dao;

import se.rosa.animal.domain.Animal;
import se.rosa.dao.Dao;

import java.util.List;

/**
 * Created by Robert on 2019-06-04.
 */
public interface AnimalDao extends Dao<Animal>{

	Animal findAnimalByName(String name);

	List<Animal> findAnimalsByName(String name);

	List<Animal> findAnimalsByType(Animal.AnimalType animalType);

	List<Animal> getAll();
}
