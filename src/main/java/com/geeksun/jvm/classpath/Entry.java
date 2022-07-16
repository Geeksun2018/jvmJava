package com.geeksun.jvm.classpath;

import java.io.File;

public abstract class Entry implements EntryInterface {

    protected final String pathListSeparator = ";";
    protected String absolutePath;

    public Entry(String path){
        this.absolutePath = getAbsolutePath(path);
    }

    public boolean isAbsolutePath(String path){
        return path.startsWith("/") || path.indexOf(":") > 0;
    }

    public String getAbsolutePath(String path){
        if(isAbsolutePath(path)){
            return path;
        }
        String filepath = System.getProperty("user.dir");
        return filepath + File.separator + path;
    }

    @Override
    public abstract byte[] readClass(String className);

    @Override
    public String toString(){
        return absolutePath;
    }

    public static Entry getProperEntry(String path){
        // TODO: 2022/7/13
        return null;
    }

}
