package com.geeksun.jvm.classfile.Attributes;

import com.geeksun.jvm.classfile.ClassReader;

public class ExceptionAttribute implements AttributeInfo{
    private int[] exceptionIndexTable;

    public ExceptionAttribute(ClassReader classReader){
        this.exceptionIndexTable = classReader.nextUint16s();
    }

    public int[] getExceptionIndexTable(){
        return exceptionIndexTable;
    }
}
