package com.geeksun.jvm.classfile.Attributes;

import com.geeksun.jvm.classfile.Attributes.AttributeInfo;
import com.geeksun.jvm.classfile.ClassReader;

public class UnparsedAttributeInfo implements AttributeInfo {
    private String name;
    private int length;
    private byte[] info;

    public UnparsedAttributeInfo(String name, int length){
        this.name = name;
        this.length = length;
    }

    @Override
    public void readInfo(ClassReader classReader) {
        this.info = classReader.readBytes(length);
    }

    public byte[] getInfo(){
        return info;
    }
}
