package com.geeksun.jvm.classfile.Attributes;

import com.geeksun.jvm.classfile.ClassReader;
import com.geeksun.jvm.classfile.ConstantPool.ConstantPool;

public class SourceFileAttribute implements AttributeInfo{
    private ConstantPool constantPool;
    private int sourceFileIndex;

    public SourceFileAttribute(ConstantPool constantPool){
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader classReader) {
        this.sourceFileIndex = classReader.nextU2toInteger();
    }

    public String getFileName(){
        return "";
    }

}
