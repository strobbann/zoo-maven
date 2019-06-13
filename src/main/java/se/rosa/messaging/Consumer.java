package se.rosa.messaging;

import se.rosa.domain.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 2019-06-13.
 */
public class Consumer implements Runnable {

	private List<Animal> events;

	private List<ProducerListener> eventListeners;

	public Consumer(List<Animal> events, ProducerListener producerListener) {
		this.events = events;
		eventListeners = new ArrayList<>();
		eventListeners.add(producerListener);
	}


	@Override
	public void run() {
		events.forEach((event) -> eventListeners.forEach(producerListener -> producerListener.on(event) ));
	}
}
