package se.rosa.logging;

public class LoggerDebug<T> implements Logger<T>{

	@Override
	public void log(String message, T t) {
		System.err.println("In class: " + t.getClass().getSimpleName() + ": " + message);
	}
}
