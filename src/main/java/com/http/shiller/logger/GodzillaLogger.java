package com.http.shiller.logger;

import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GodzillaLogger extends AbstractLogger {

    class StreamSource {
        @Getter
        @Setter
        private OutputStream outputStream;
        @Getter
        private FileStreamParams fileParams;
        StreamSource(OutputStream outputStream, FileStreamParams fileParams) {
            this.outputStream = outputStream;
            this.fileParams = fileParams;
        }
        StreamSource(OutputStream outputStream) {
            this.outputStream = outputStream;
            this.fileParams = new FileStreamParams();
        }

        @Override
        public String toString() {
            return String.format("StreamSource: [outputStream = %s, fileParams = %s]", outputStream, fileParams);
        }
    }
    class FileStreamParams {
        @Getter
        private String filePath;
        @Getter
        private boolean append;
        @Getter
        private boolean archieve;
        @Getter
        private long maxLogSize;

        FileStreamParams() {
            this.filePath = "";
            this.append = false;
            this.archieve = false;
            this.maxLogSize = 0;
        }

        FileStreamParams(String filePath) {
            this.filePath = filePath;
            this.append = false;
            this.archieve = false;
            this.maxLogSize = 0;
        }

        FileStreamParams(String filePath, boolean append) {
            this.filePath = filePath;
            this.append = append;
            this.archieve = false;
            this.maxLogSize = 0;
        }

        FileStreamParams(String filePath, boolean append, boolean archieve, long maxLogSize) {
            this.filePath = filePath;
            this.append = append;
            this.archieve = archieve;
            this.maxLogSize = maxLogSize;
        }

        @Override
        public String toString() {
            return String.format("FileStreamParams: [filePath = %s, append = %b, archieve = %b, maxLogSize = %d]",
                    filePath, append, archieve, maxLogSize);
        }
    }

    private List<StreamSource> streamsToLog = new ArrayList<>();


    public void addOutputStream(PrintStream outputStream) {
        streamsToLog.add(new StreamSource(outputStream));
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
            //@Cleanup
            FileOutputStream fileStream = new FileOutputStream(filePath, append);
            streamsToLog.add(new StreamSource(fileStream, new FileStreamParams(filePath, append)));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("File '%s' doesn't exist", filePath));
        }
    }

    public void addOutputStream(FileOutputStream outputStream, FileStreamParams fileStreamParams) {
        streamsToLog.add(new StreamSource(outputStream, fileStreamParams));
    }







    public void clearOutputStreamList() {
        streamsToLog = new ArrayList<>();
        streamsToLog.add(new StreamSource(System.out));
    }














    public GodzillaLogger() {
        System.out.println("Godzilla logger init");
        streamsToLog.add(new StreamSource(System.out));
    }

    public GodzillaLogger(boolean append, String... filePaths) {
        System.out.println("Godzilla logger init");
        streamsToLog.add(new StreamSource(System.out));
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
                @Cleanup
                FileOutputStream fileStream = new FileOutputStream(o, append);
                streamsToLog.add(new StreamSource(fileStream, new FileStreamParams(o, append)));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(String.format("File '%s' doesn't exist", o));
            }
        });
    }







    @Override
    protected void log(LogTypes type, String message) {
        StringBuilder builder = new StringBuilder();
        builder
                .append(new Timestamp(System.currentTimeMillis()))
                .append(" [GODZILLA ")
                .append(type.name())
                .append("]: ")
                .append(message);

        for (StreamSource o : streamsToLog) {
            System.out.println(o);

            try {
                if (o.getOutputStream() == null) {
                    System.out.println(o.getOutputStream());
                    o.setOutputStream(new FileOutputStream(o.getFileParams().getFilePath(), true));
                    System.out.println(o.getOutputStream());
                }
            } catch(java.io.IOException e) {
                System.out.println("Hmm...some shit hpnd...");
            }


            if (o.getOutputStream() instanceof PrintStream) {
                PrintStream printStream = (PrintStream)o.getOutputStream();
                printStream.println(builder.toString());
            } else {
                if (o.getOutputStream() instanceof FileOutputStream) {
                    try {

                        if (o.getOutputStream() == null) {
                            o.setOutputStream(new FileOutputStream(o.getFileParams().getFilePath(), true));
                        }
                        try {
                            if (o.getOutputStream() == null) {
                                System.out.println(o.getOutputStream());
                                o.getOutputStream().close();
                                o.setOutputStream(new FileOutputStream(o.getFileParams().getFilePath(), true));
                                System.out.println(o.getOutputStream());
                            }
                        } catch(java.io.IOException e) {
                            System.out.println("Hmm...some shit hpnd...");
                        }



                        byte b[] = builder.toString().getBytes();
                        byte end[] = "\n".getBytes();
                        o.getOutputStream().write(b);
                        o.getOutputStream().write(end);
                        o.getOutputStream().close();
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
