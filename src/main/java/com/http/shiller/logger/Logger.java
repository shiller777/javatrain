package com.http.shiller.logger;

public interface Logger {
    void info(String message);
    void warn(String message);
    void debug(String message);
    void error(String message);
    void error(Throwable something);

}
