package com.geeksun.jvm.classfile.Attributes;

import com.geeksun.jvm.classfile.ClassReader;

public class ConstantValueAttribute implements AttributeInfo{
    private int constantValueIndex;

    public ConstantValueAttribute(ClassReader classReader){
        this.constantValueIndex = classReader.nextU2toInteger();
    }

    public int getConstantValueIndex(){
        return constantValueIndex;
    }

}
