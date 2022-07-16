package com.geeksun.jvm.classpath;

import java.util.List;

public class CompositeEntry extends Entry {
    private List<Entry> entryList = null;

    public CompositeEntry(String path) {
        super(path);
        String[] paths = path.split(pathListSeparator);
        for(String p:paths){
            entryList.add(Entry.getProperEntry(p));
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
