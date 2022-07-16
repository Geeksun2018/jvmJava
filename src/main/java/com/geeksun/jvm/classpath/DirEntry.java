package com.geeksun.jvm.classpath;

import com.geeksun.jvm.util.FileUtils;

import java.io.File;
import java.io.IOException;

public class DirEntry extends Entry{

    public DirEntry(String path){
        super(path);
    }

    @Override
    public byte[] readClass(String className) {
        try {
            return FileUtils.readFile(new File(absolutePath, className));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
