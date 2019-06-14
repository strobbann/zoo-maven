package se.rosa.logging;

/**
 * Created by Robert on 2019-06-13.
 */
public class LoggerConsole implements Logger{

    @Override
    public void log(String message, Object obj) {
        System.out.println("In class: " + obj.getClass().getSimpleName() + " : " + message);
    }
}
