package se.rosa.logging;

public class LoggerDebug implements Logger{

	@Override
	public void log(String message, Object obj) {
		System.err.println("in class: " + obj.getClass().getSimpleName()+ ": " + message);
	}
}
