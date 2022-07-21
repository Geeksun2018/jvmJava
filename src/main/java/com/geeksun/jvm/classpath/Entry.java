package com.geeksun.jvm.classpath;

import java.io.File;

public abstract class Entry implements EntryInterface {

    protected static final String pathListSeparator = ";";
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
        if(path.contains(pathListSeparator)){
            return new CompositeEntry(path);
        }
        if(path.endsWith("*")){
            return new WildcardEntry(path);
        }
        if(path.endsWith("jar")||path.endsWith("JAR")||path.endsWith("zip")||path.endsWith("ZIP")){
            return new ZipEntry(path);
        }
        return new DirEntry(path);
    }

}
