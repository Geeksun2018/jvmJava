package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;

public class ConstantMethodRefInfo extends ConstantMemberRefInfo{
    public ConstantMethodRefInfo(ConstantPool constantPool, ClassReader classReader) {
        super(constantPool, classReader);
    }
}
