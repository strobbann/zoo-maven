package se.rosa.domain;

import javax.swing.text.html.Option;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by Robert on 2019-06-04.
 */
public class Animal {

	private Long id;
	private String name;
	private AnimalType animalType;


	private Animal(Builder builder) {
		this.id = Objects.requireNonNull(builder.id, "id cannot be null");
		this.name = Objects.requireNonNull(builder.name, "name cannot be null");
		this.animalType = Optional.ofNullable(builder.animalType).orElse(AnimalType.UNSPECIFIED);
	}

	public enum AnimalType {
		BIRD, CAT, DOG, UNSPECIFIED
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public AnimalType getType() {
		return animalType;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private Long id;
		private String name;
		private AnimalType animalType;


		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withType(AnimalType animalType) {
			this.animalType = animalType;
			return this;
		}

		public Animal build() {
			return new Animal(this);
		}

	}
}
