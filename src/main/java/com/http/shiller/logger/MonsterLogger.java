package com.http.shiller.logger;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonsterLogger extends AbstractLogger {

    private List<OutputStream> streamsToLog = new ArrayList<>();

    public MonsterLogger() {
        System.out.println("Monster logger init");
        streamsToLog.add(System.out);
    }

    public MonsterLogger(boolean append, String... filePaths) {
        System.out.println("Monster logger init");
        streamsToLog.add(System.out);
        List<String> filePathsList = Arrays.asList(filePaths);

        filePathsList.forEach(o -> {
            try {
                boolean fileOk = true;
                if (!new File(o).exists()) {
                    fileOk = new File(o).createNewFile();
                }
                if (!fileOk) {
                    throw new RuntimeException(String.format("Cannot create file '%s'", o));
                }
                FileOutputStream fileStream = new FileOutputStream(o, append);
                streamsToLog.add(fileStream);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(String.format("File '%s' doesn't exist", o));
            }
        });
    }




    public void addOutputStream(OutputStream outputStream) {
        streamsToLog.add(outputStream);
    }
    public void addPrintFile(String filePath, boolean append) {
        try {
            boolean fileOk = true;
            if (!new File(filePath).exists()) {
                fileOk = new File(filePath).createNewFile();
            }
            if (!fileOk) {
                throw new RuntimeException(String.format("Cannot create file '%s'", filePath));
            }
            FileOutputStream fileStream = new FileOutputStream(filePath, append);
            streamsToLog.add(fileStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("File '%s' doesn't exist", filePath));
        }
    }
    public void clearOutputStreamList() {
        streamsToLog = new ArrayList<>();
        streamsToLog.add(System.out);
    }


    @Override
    protected void log(LogTypes type, String message) {
        StringBuilder builder = new StringBuilder();
        builder
                .append(new Timestamp(System.currentTimeMillis()))
                .append(" [MONSTER ")
                .append(type.name())
                .append("]: ")
                .append(message);

        for (OutputStream o : streamsToLog) {
            if (o instanceof PrintStream) {
                PrintStream printStream = (PrintStream)o;
                printStream.println(builder.toString());
            } else {
                if (o instanceof FileOutputStream) {
                    try {
                        byte b[] = builder.toString().getBytes();
                        byte end[] = "\n".getBytes();
                        o.write(b);
                        o.write(end);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    throw new RuntimeException(
                            String.format("Only PrintStream is supported for now but not '%s'", o.getClass()));
                }
            }
        }
    }
}
