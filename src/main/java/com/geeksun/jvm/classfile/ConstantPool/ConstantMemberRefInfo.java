package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;

public class ConstantMemberRefInfo implements ConstantInfo{
    private ConstantPool constantPool;
    private int classIndex;
    private int nameAndTypeIndex;

    public ConstantMemberRefInfo(ClassReader classReader){
        this.classIndex = classReader.nextU2toInteger();
        this.nameAndTypeIndex = classReader.nextU2toInteger();
    }

    @Override
    public String getInfo() {
        return null;
    }
}
