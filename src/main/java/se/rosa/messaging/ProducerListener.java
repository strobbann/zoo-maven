package se.rosa.messaging;

/**
 * Created by Robert on 2019-06-13.
 */
public interface ProducerListener {
	<U> void on(U u);

}
