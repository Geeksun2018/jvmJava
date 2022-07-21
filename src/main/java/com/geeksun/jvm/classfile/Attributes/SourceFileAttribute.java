package com.geeksun.jvm.classfile.Attributes;

import com.geeksun.jvm.classfile.ClassReader;
import com.geeksun.jvm.classfile.ConstantPool.ConstantPool;

public class SourceFileAttribute implements AttributeInfo{
    private ConstantPool constantPool;
    private int sourceFileIndex;

    public SourceFileAttribute(ClassReader classReader, ConstantPool constantPool){
        this.constantPool = constantPool;
        this.sourceFileIndex = classReader.nextU2toInteger();
    }

    public String getFileName(){
        return constantPool.getUtf8(sourceFileIndex);
    }

}
