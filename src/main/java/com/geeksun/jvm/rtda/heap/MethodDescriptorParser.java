package com.geeksun.jvm.rtda.heap;

public class MethodDescriptorParser {
    private String raw;
    private int offset;
    private MethodDescriptor parsed;

    public MethodDescriptorParser(String descriptor){
        this.raw = descriptor;
        this.parsed = new MethodDescriptor();
    }



}
