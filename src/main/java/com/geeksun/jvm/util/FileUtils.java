package com.geeksun.jvm.util;

import java.io.*;
import java.nio.file.Files;

public class FileUtils {

    public static byte[] readFile(File file) throws IOException {
        try (BufferedInputStream fileInputStream = new BufferedInputStream(Files.newInputStream(file.toPath())); ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length())) {
            byte[] buffer = new byte[1024];
            while (fileInputStream.read(buffer) > 0) {
                bos.write(buffer);
            }
            return bos.toByteArray();
        }

    }

    public static byte[] readFile(InputStream ins) throws IOException {
        try (BufferedInputStream fileInputStream = new BufferedInputStream(ins); ByteArrayOutputStream bos = new ByteArrayOutputStream(ins.available())) {
            byte[] buffer = new byte[1024];
            while (fileInputStream.read(buffer) > 0) {
                bos.write(buffer);
            }
            return bos.toByteArray();
        }

    }

}
