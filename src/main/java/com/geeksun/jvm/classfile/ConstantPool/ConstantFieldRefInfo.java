package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;

public class ConstantFieldRefInfo extends ConstantMemberRefInfo{
    public ConstantFieldRefInfo(ConstantPool constantPool, ClassReader classReader) {
        super(constantPool, classReader);
    }
}
