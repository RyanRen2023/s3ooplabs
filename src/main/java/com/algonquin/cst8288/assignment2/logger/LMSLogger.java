package com.algonquin.cst8288.assignment2.logger;

import static com.algonquin.cst8288.assignment2.logger.LogLevel.DEBUG;
import static com.algonquin.cst8288.assignment2.logger.LogLevel.ERROR;
import static com.algonquin.cst8288.assignment2.logger.LogLevel.INFO;
import static com.algonquin.cst8288.assignment2.logger.LogLevel.TRACE;
import static com.algonquin.cst8288.assignment2.logger.LogLevel.WARN;

public class LMSLogger {

    private static LMSLogger lmsLogger;

    LogLevel logLevel;

    private LMSLogger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;

    }

    public static LMSLogger getLMSLogger() {
        if (lmsLogger == null) {
            lmsLogger = new LMSLogger(LogLevel.INFO);
        }
        return lmsLogger;
    }

    public void log(String log) {
        log(logLevel, log);
    }

    private void log(LogLevel logLevel, String log) {

        switch (logLevel) {
            case TRACE:
                System.out.printf("Logger Level TRACE : %s\n", log);
                break;
            case DEBUG:
                System.out.printf("Logger Level DEBUG: %s\n", log);
                break;
            case INFO:
                System.out.printf("Logger Level INFO : %s\n", log);
                break;
            case WARN:
                System.out.printf("Logger Level WARN: %s\n", log);
                break;
            case ERROR:
                System.out.printf("Logger Level ERROR : %s\n", log);
                break;
        }
    }

    public void info(String log) {
        this.log(LogLevel.INFO, log);
    }

    public void debug(String log) {
        this.log(LogLevel.DEBUG, log);
    }

    public void error(String log) {
        this.log(LogLevel.ERROR, log);
    }

    public void trace(String log) {
        this.log(LogLevel.TRACE, log);
    }

    public void warn(String log) {
        this.log(LogLevel.WARN, log);
    }

}
