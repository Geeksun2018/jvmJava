package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;

public class ConstantIntegerInfo implements ConstantInfo{

    private int val;

    public ConstantIntegerInfo(ClassReader classReader){
        this.val = classReader.nextU4toInteger();
    }

    @Override
    public String getInfo() {
        return String.valueOf(val);
    }
}
