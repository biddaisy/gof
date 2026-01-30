package com.github.biddaisy.gof;

import static java.lang.System.Logger.Level.*;

/**
 * Custom logging utility for the Composite Pattern demonstration.
 * Provides a simplified interface for logging messages at various levels.
 *
 * <p>This class wraps the standard System.Logger to provide:
 * <ul>
 *   <li>Simplified static methods for logging</li>
 *   <li>Consistent logger name ("gof.logger")</li>
 *   <li>Support for different log levels</li>
 *   <li>Parameter substitution in log messages</li>
 * </ul>
 *
 * <p>Usage examples:
 * <pre>
 * Logger.log("Simple message");
 * Logger.log("Price: {0}", price);
 * Logger.error("Error occurred", exception);
 * </pre>
 *
 * @see java.lang.System.Logger
 */
public class Logger {

    public static final String GOF_LOGGER = "gof.logger";

    /**
     * Private constructor to prevent instantiation.
     * This is a utility class with only static methods.
     */
    private Logger() {
    }

    /**
     * Logs an informational message.
     *
     * @param message the message to log
     */
    public static void log(String message) {
        System.getLogger(GOF_LOGGER).log(INFO, message);
    }

    /**
     * Logs an informational message with parameters.
     * Parameters are substituted using MessageFormat syntax.
     *
     * @param message the message template with placeholders
     * @param params parameters to substitute into the message
     */
    public static void log(String message, Object... params) {
        System.getLogger(GOF_LOGGER).log(INFO, message, params);
    }

    /**
     * Logs an error message.
     *
     * @param message the error message
     */
    public static void error(String message) {
        System.getLogger(GOF_LOGGER).log(ERROR, message);
    }

    /**
     * Logs an error message with parameters.
     *
     * @param message the error message template
     * @param params parameters to substitute
     */
    public static void error(String message, Object... params) {
        System.getLogger(GOF_LOGGER).log(ERROR, message, params);
    }

    /**
     * Logs an error message with an exception.
     *
     * @param message the error message
     * @param throwable the exception to log
     */
    public static void error(String message, Throwable throwable) {
        System.getLogger(GOF_LOGGER).log(ERROR, message, throwable);
    }

    /**
     * Logs a warning message.
     *
     * @param message the warning message
     */
    public static void warn(String message) {
        System.getLogger(GOF_LOGGER).log(WARNING, message);
    }

    /**
     * Logs a warning message with parameters.
     *
     * @param message the warning message template
     * @param params parameters to substitute
     */
    public static void warn(String message, Object... params) {
        System.getLogger(GOF_LOGGER).log(WARNING, message, params);
    }

    /**
     * Logs a debug message.
     * Debug messages are typically only shown during development.
     *
     * @param message the debug message
     */
    public static void debug(String message) {
        System.getLogger(GOF_LOGGER).log(DEBUG, message);
    }

    /**
     * Logs a debug message with parameters.
     *
     * @param message the debug message template
     * @param params parameters to substitute
     */
    public static void debug(String message, Object... params) {
        System.getLogger(GOF_LOGGER).log(DEBUG, message, params);
    }
}