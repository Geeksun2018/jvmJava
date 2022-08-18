package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;

public class ConstantStringInfo implements ConstantInfo{
    private ConstantPool constantPool;
    private int stringIndex;

    public ConstantStringInfo(ConstantPool constantPool, ClassReader classReader){
        this.constantPool = constantPool;
        this.stringIndex = classReader.nextU2toInteger();
    }

    public String getString(){
        return constantPool.getUtf8(stringIndex);
    }
    @Override
    public String getInfo() {
        return null;
    }
}
