package com.geeksun.jvm.classpath;

import java.io.File;
import java.util.Objects;

public class Classpath {
    private Entry bootClasspathEntry;
    private Entry extClasspathEntry;
    private Entry userClasspathEntry;

    public Classpath(String jreOption, String cpOption){
        parseBootAndExtClasspath(jreOption);
        parseUserClasspath(cpOption);
    }

    private void parseUserClasspath(String cpOption) {
        if (Objects.equals(cpOption, "")) {
            cpOption = ".";
        }
        userClasspathEntry = new WildcardEntry(cpOption);
    }

    private void parseBootAndExtClasspath(String jreOption){
        String jreLibPath = getJreDir(jreOption) + File.separator + "lib" + File.separator + "*";
        String jreExtPath = getJreDir(jreOption) + File.separator + "lib" + File.separator + "ext" + File.separator + "*";
        bootClasspathEntry = new WildcardEntry(jreLibPath);
        extClasspathEntry = new WildcardEntry(jreExtPath);
    }

    private String getJreDir(String jreOption){
        if(!jreOption.equals("")&&new File(jreOption).exists()){
            return jreOption;
        }
        if(new File("./jre").exists()){
            return "./jre";
        }
        return System.getProperty("java.home");
    }

    public byte[] readClass(String className){
        className = className + ".class";
        byte[] data;
        if((data = bootClasspathEntry.readClass(className)) != null){
            return data;
        }
        if((data = extClasspathEntry.readClass(className)) != null){
            return data;
        }
        return userClasspathEntry.readClass(className);
    }

    @Override
    public String toString() {
        return userClasspathEntry.toString();
    }
}
