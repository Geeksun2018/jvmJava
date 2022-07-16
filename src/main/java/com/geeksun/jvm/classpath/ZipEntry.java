package com.geeksun.jvm.classpath;

import com.geeksun.jvm.util.FileUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;

public class ZipEntry extends Entry{

    public ZipEntry(String path) {
        super(path);
    }

    @Override
    public byte[] readClass(String className) {
        if(absolutePath.endsWith("jar")||absolutePath.endsWith("JAR")){
            try(JarFile jarFile = new JarFile(absolutePath)){
                Enumeration<JarEntry> entries = jarFile.entries();
                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = entries.nextElement();
                    if(jarEntry.getName().equals(className)){
                        InputStream inputStream = jarFile.getInputStream(jarEntry);
                        return FileUtils.readFile(inputStream);
                    }

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else if (absolutePath.endsWith("ZIP")||absolutePath.endsWith("zip")) {
            try(ZipFile zipFile = new ZipFile(absolutePath)){
                Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    java.util.zip.ZipEntry zipEntry = entries.nextElement();
                    if(zipEntry.getName().equals(className)){
                        InputStream inputStream = zipFile.getInputStream(zipEntry);
                        return FileUtils.readFile(inputStream);
                    }
                }
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}
