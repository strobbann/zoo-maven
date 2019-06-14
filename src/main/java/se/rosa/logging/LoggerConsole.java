package se.rosa.logging;

/**
 * Created by Robert on 2019-06-13.
 */
public class LoggerConsole<T> implements Logger<T>{

    @Override
    public void log(String message, T t) {
        System.out.println("In class: " + t.getClass().getSimpleName() + " : " + message);
    }
}
