package com.geeksun.jvm;

import com.geeksun.jvm.classpath.EntryInterface;

public class ClassTest implements EntryInterface {
    private String str;
    private int a = 123456;

    public ClassTest(){
        str = "Geeksun!!!";
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }


    @Override
    public byte[] readClass(String className) {
        return new byte[0];
    }
}
