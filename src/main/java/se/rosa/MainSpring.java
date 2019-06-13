package se.rosa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import se.rosa.dao.AnimalDao;
import se.rosa.domain.Animal;
import se.rosa.messaging.Consumer;
import se.rosa.messaging.Producer;
import se.rosa.service.AnimalService;

/**
 * Created by Robert on 2019-06-12.
 */
public class MainSpring {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext(args);
		AnimalService animalService = context.getBean(AnimalService.class);
		AnimalDao animalDao = context.getBean(AnimalDao.class);
		animalDao.create(Animal.builder().withId(1L).withName("Hello World").withType(Animal.AnimalType.BIRD).build());
		System.out.println(animalService.getNamesOfAllAnimals());

		Producer producer = new Producer();
		Consumer consumer = new Consumer(producer.getEvents(), System.out::println);

		new Thread(producer).start();
		new Thread(consumer).start();
	}
}
