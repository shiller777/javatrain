package com.http.shiller.logger;

import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseLogger extends AbstractLogger {

//    private List<OutputStream> streamsToLog = new ArrayList<>();
//
// BaseLogger now is readonly
// create new logger class, extend it from AbstractLogger
// List<OutputStream> in new class
// NewLogger(String... paths);
// ArchiveLogger(int maxSize);



    @Override
    protected void log(LogTypes type, String message) {
        StringBuilder builder = new StringBuilder();
        builder
                .append(new Timestamp(System.currentTimeMillis()))
                .append(" [")
                .append(type.name())
                .append("]: ")
                .append(message);
        System.out.println(builder.toString());
    }

}
