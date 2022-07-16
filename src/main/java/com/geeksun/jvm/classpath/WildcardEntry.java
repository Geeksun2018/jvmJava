package com.geeksun.jvm.classpath;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WildcardEntry extends Entry {
    private final List<Entry> entryList = new ArrayList<>();

    public WildcardEntry(String path) {
        super(path);
        String newPath = absolutePath.substring(0, absolutePath.length() - 1);
        File file = new File(newPath);
        String[] files = file.list();
        if (files != null) {
            for(String f:files){
                if(f.endsWith("zip")||f.endsWith("ZIP")||f.endsWith("jar")||f.endsWith("JAR")){
                    entryList.add(new ZipEntry(newPath + File.separator + f));
                }
            }
        }
    }

    @Override
    public byte[] readClass(String className) {
        byte[] data;
        for(Entry entry:entryList){
            if((data = entry.readClass(className))!=null){
                return data;
            }
        }
        return null;
    }
}
