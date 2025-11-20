package design_patterns.poliflix.utils;

public interface Logger {
    default void log(String loggerName, String message) {
        System.out.println(loggerName + " " + message);
    }
}
