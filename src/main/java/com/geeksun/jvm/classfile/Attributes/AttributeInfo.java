package com.geeksun.jvm.classfile.Attributes;

import com.geeksun.jvm.classfile.ClassReader;
import com.geeksun.jvm.classfile.ConstantPool.ConstantPool;

public interface AttributeInfo {
    void readInfo(ClassReader classReader);

    static AttributeInfo readAttribute(ClassReader classReader, ConstantPool constantPool){
        int attrNameIndex = classReader.nextU2toInteger();
//        String attrName = constantPool.toString();
        int attrLen = classReader.nextU4toInteger();

        return null;
    }

}
