package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;

public class ConstantMemberRefInfo implements ConstantInfo{
    private ConstantPool constantPool;
    private int classIndex;
    private int nameAndTypeIndex;

    public ConstantMemberRefInfo(ConstantPool constantPool, ClassReader classReader){
        this.constantPool = constantPool;
        this.classIndex = classReader.nextU2toInteger();
        this.nameAndTypeIndex = classReader.nextU2toInteger();
    }

    public String getClassName(){
        return this.constantPool.getClassName(classIndex);
    }

    public String getNameAndDescriptor(){
        return this.constantPool.getNameAndType(nameAndTypeIndex);
    }

    @Override
    public String getInfo() {
        return null;
    }
}
