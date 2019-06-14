package se.rosa.logging;

/**
 * Created by Robert on 2019-06-13.
 */
public interface Logger<T> {

    void log(String message, T t);
}
