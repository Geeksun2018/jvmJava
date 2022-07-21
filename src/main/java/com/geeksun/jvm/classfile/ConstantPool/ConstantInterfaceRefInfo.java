package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;

public class ConstantInterfaceRefInfo extends ConstantMemberRefInfo{
    public ConstantInterfaceRefInfo(ConstantPool constantPool, ClassReader classReader) {
        super(constantPool, classReader);
    }
}
