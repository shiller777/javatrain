package com.http.shiller.logger;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GodzillaLogger extends MonsterLogger {

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

                FileOutputStream fileStream = new FileOutputStream(o, append);
                streamsToLog.add(new StreamSource(fileStream, new FileStreamParams(o, append)));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(String.format("File '%s' doesn't exist", o));
            }
        });
    }

    public void addOutputStream(PrintStream outputStream) {
        streamsToLog.add(new StreamSource(outputStream));
    }
    public void addPrintFile(String filePath, boolean append) {
        FileStreamParams fileStreamParams = new FileStreamParams(filePath, append);
        addPrintFile(fileStreamParams);
        /*
        try {
            boolean fileOk = true;
            if (!new File(filePath).exists()) {
                fileOk = new File(filePath).createNewFile();
            }
            if (!fileOk) {
                throw new RuntimeException(String.format("Cannot create file '%s'", filePath));
            }

            FileOutputStream fileStream = new FileOutputStream(filePath, append);
            streamsToLog.add(new StreamSource(fileStream, new FileStreamParams(filePath, append)));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("File '%s' doesn't exist", filePath));
        }
        */
    }
    public void addPrintFile(String filePath, boolean append, boolean archieve, long maxLogSize) {
        FileStreamParams fileStreamParams = new FileStreamParams(filePath, append, archieve, maxLogSize);
        addPrintFile(fileStreamParams);
        /*
        try {
            boolean fileOk = true;
            if (!new File(filePath).exists()) {
                fileOk = new File(filePath).createNewFile();
            }
            if (!fileOk) {
                throw new RuntimeException(String.format("Cannot create file '%s'", filePath));
            }

            FileOutputStream fileStream = new FileOutputStream(filePath, append);
            streamsToLog.add(new StreamSource(fileStream, new FileStreamParams(filePath, append, archieve, maxLogSize)));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("File '%s' doesn't exist", filePath));
        }
        */
    }
    private void addPrintFile(FileStreamParams fileStreamParams) {
        try {
            boolean fileOk = true;
            if (!new File(fileStreamParams.getFilePath()).exists()) {
                fileOk = new File(fileStreamParams.getFilePath()).createNewFile();
            }
            if (!fileOk) {
                throw new RuntimeException(String.format("Cannot create file '%s'", fileStreamParams.getFilePath()));
            }

            FileOutputStream fileStream = new FileOutputStream(fileStreamParams.getFilePath(), fileStreamParams.isAppend());
            streamsToLog.add(new StreamSource(fileStream,
                    new FileStreamParams(fileStreamParams.getFilePath(), fileStreamParams.isAppend(),
                            fileStreamParams.isArchieve(), fileStreamParams.getMaxLogSize())));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("File '%s' doesn't exist", fileStreamParams.getFilePath()));
        }
    }










    public void addOutputStream(FileOutputStream outputStream, FileStreamParams fileStreamParams) {
        streamsToLog.add(new StreamSource(outputStream, fileStreamParams));
    }

    public void clearOutputStreamList() {
        streamsToLog = new ArrayList<>();
        streamsToLog.add(new StreamSource(System.out));
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
            if (o.getOutputStream() instanceof PrintStream) {
                PrintStream printStream = (PrintStream)o.getOutputStream();
                printStream.println(builder.toString());
            } else {
                if(o.getOutputStream() instanceof FileOutputStream) {
                    try {
                        byte b[] = builder.toString().getBytes();
                        byte end[] = "\n".getBytes();
                        o.getOutputStream().write(b);
                        o.getOutputStream().write(end);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    throw new RuntimeException(
                            String.format("Only PrintStream is supported for now but not '%s'",
                                    o.getOutputStream().getClass()));
                }
            }
        }
    }

    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////

    public void checkAndArchieve() {
        for (StreamSource o : streamsToLog) {
            if(o.getOutputStream() instanceof FileOutputStream) {
                // close
                if (o.getFileParams().isArchieve()) {
                    try {
                        o.getOutputStream().close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                // check
                File file = new File(o.getFileParams().getFilePath());
                long fileSize = file.length();

                // archieve if necessary
                boolean needAppend = o.getFileParams().append;

                if (fileSize > o.getFileParams().getMaxLogSize()) {
                    needAppend = false;
                    // arc here
                    archieve(o.getFileParams().getFilePath());
                }
                // open
                try {
                    o.setOutputStream(new FileOutputStream(o.getFileParams().getFilePath(), needAppend));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    throw new RuntimeException(String.format("File '%s' doesn't exist", o.getFileParams().getFilePath()));
                }
            }
        }
    }











    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////


    public void archieve(String filePath) {

        String sourceFile = filePath;

        int beginExt = filePath.lastIndexOf(".");
        String filePathWithoutExt = filePath.substring(0, beginExt);

        Date now = new Date();
        Timestamp lalala = new Timestamp(now.getTime());

        String zipPath = (filePathWithoutExt + "_"
                + lalala.toString().replace(":", "_")
                + ".zip")
                .replace(" ", "_");

        try {
            FileOutputStream fos = null;

            File zipFile = new File(zipPath);
            if (!zipFile.exists()) {
                zipFile.createNewFile();
            }

            fos = new FileOutputStream(zipPath);
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            File fileToZip = new File(sourceFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            zipOut.close();
            fis.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
