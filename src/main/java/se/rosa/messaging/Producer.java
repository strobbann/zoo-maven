package se.rosa.messaging;

import se.rosa.domain.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Robert on 2019-06-13.
 */
public class Producer implements Runnable {

	private Random random = new Random();

	private List<Animal> events = new ArrayList<>();

	@Override
	public void run() {
		events.add(Animal.builder().withId(random.nextLong()).withName("Test").withType(Animal.AnimalType.values()[random.nextInt(4)]).build());
	}

	public List<Animal> getEvents() {
		return events;
	}
}
