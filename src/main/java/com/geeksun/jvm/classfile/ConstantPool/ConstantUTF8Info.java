package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;

public class ConstantUTF8Info implements ConstantInfo{

    private String str;

    public ConstantUTF8Info(ClassReader classReader){
        int length = classReader.nextU2toInteger();
        byte[] bytes = classReader.readBytes(length);
        str = new String(bytes);
    }

    @Override
    public String getInfo() {
        return str;
    }
}
