package com.geeksun.jvm.classfile.Attributes;

import com.geeksun.jvm.classfile.ClassReader;
import com.geeksun.jvm.classfile.ConstantPool.ConstantPool;

public interface AttributeInfo {
    static AttributeInfo[] readAttributes(ClassReader classReader, ConstantPool constantPool) {
        int attributeCount = classReader.nextU2toInteger();
        AttributeInfo[] attributeInfos = new AttributeInfo[attributeCount];
        for(int i = 0;i < attributeCount;i++){
            attributeInfos[i] = readAttribute(classReader, constantPool);
        }
        return attributeInfos;
    }

    static AttributeInfo newAttributeInfo(String attrName, int attrLen, ConstantPool constantPool, ClassReader classReader){
        switch (attrName){
            case "Code":
                return new CodeAttribute(classReader, constantPool);
            case "ConstantValue":
                return new ConstantValueAttribute(classReader);
            case "Deprecated":
                return new DeprecatedAttribute();
            case "Exceptions":
                return new ExceptionAttribute(classReader);
            case "LineNumberTable":
                return new LineNumberTableAttribute(classReader);
            case "LocalVariableTable":
                return new LocalVariableTableAttribute(classReader);
            case "SourceFile":
                return new SourceFileAttribute(classReader, constantPool);
            case "Synthetic":
                return new SyntheticAttribute();
            default:
                return new UnparsedAttributeInfo(classReader, attrName, attrLen);
        }
    }

    static AttributeInfo readAttribute(ClassReader classReader, ConstantPool constantPool){
        int attrNameIndex = classReader.nextU2toInteger();
        String attrName = constantPool.getUtf8(attrNameIndex);
        int attrLen = classReader.nextU4toInteger();
        return newAttributeInfo(attrName, attrLen, constantPool, classReader);
    }

}
