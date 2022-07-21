package com.geeksun.jvm.classfile.Attributes;

import com.geeksun.jvm.classfile.ClassReader;
import com.geeksun.jvm.classfile.ConstantPool.ConstantPool;
import lombok.AllArgsConstructor;

public class CodeAttribute implements AttributeInfo{
    private ConstantPool constantPool;
    private int maxStack;
    private int maxLocals;
    private byte[] code;
    private ExceptionTableEntry[] exceptionTable;
    private AttributeInfo[] attributeInfos;

    public CodeAttribute(ClassReader classReader, ConstantPool constantPool){
        this.maxStack = classReader.nextU2toInteger();
        this.maxLocals = classReader.nextU2toInteger();
        int codeLength = classReader.nextU4toInteger();
        this.code = classReader.readBytes(codeLength);
        this.exceptionTable = readExceptionTable(classReader);
        this.attributeInfos = AttributeInfo.readAttributes(classReader, constantPool);
    }


    private ExceptionTableEntry[] readExceptionTable(ClassReader classReader){
        int exceptionTableLength = classReader.nextU2toInteger();
        ExceptionTableEntry[] exceptionTable = new ExceptionTableEntry[exceptionTableLength];
        for(int i = 0;i < exceptionTableLength;i++){
            int startPc = classReader.nextU2toInteger();
            int endPc = classReader.nextU2toInteger();
            int handlerPc = classReader.nextU2toInteger();
            int catchType = classReader.nextU2toInteger();
            exceptionTable[i] = new ExceptionTableEntry(startPc, endPc, handlerPc, catchType);
        }
        return exceptionTable;
    }
}

@AllArgsConstructor
class ExceptionTableEntry{
    private int startPc;
    private int endPc;
    private int handlerPc;
    private int catchType;
}
