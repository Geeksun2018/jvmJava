package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;

public class ConstantStringInfo implements ConstantInfo{
    private ConstantPool constantPool;
    private int stringIndex;

    public ConstantStringInfo(ClassReader classReader){
        this.stringIndex = classReader.nextU2toInteger();
    }


    @Override
    public String getInfo() {
        return null;
    }
}
