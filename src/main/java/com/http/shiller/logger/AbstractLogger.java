package com.http.shiller.logger;

public abstract class AbstractLogger implements Logger {
    protected enum LogTypes {
        INFO,
        WARN,
        DEBUG,
        ERROR;
    }
    public void info(String message) {
        log(LogTypes.INFO, message);
    }

    public void warn(String message) {
        log(LogTypes.WARN, message);
    }

    public void debug(String message) {
        log(LogTypes.DEBUG, message);
    }

    public void error(String message) {
        log(LogTypes.ERROR, message);
    }

    @Override
    public void error(Throwable something) {
        log(LogTypes.ERROR, something.getMessage());
    }

    protected abstract void log(LogTypes type, String message);
}
