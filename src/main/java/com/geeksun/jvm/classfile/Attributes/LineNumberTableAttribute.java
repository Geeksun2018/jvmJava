package com.geeksun.jvm.classfile.Attributes;

import com.geeksun.jvm.classfile.ClassReader;
import com.sun.org.apache.bcel.internal.classfile.LineNumberTable;
import lombok.AllArgsConstructor;

public class LineNumberTableAttribute implements AttributeInfo{
    private LineNumberTableEntry[] lineNumberTable;

    @Override
    public void readInfo(ClassReader classReader) {
        int lineNumberTableLength = classReader.nextU2toInteger();
        this.lineNumberTable = new LineNumberTableEntry[lineNumberTableLength];
        for(int i = 0;i < lineNumberTableLength;i++){
            this.lineNumberTable[i] = new LineNumberTableEntry(classReader.nextU2toInteger(), classReader.nextU2toInteger());
        }
    }
}

@AllArgsConstructor
class LineNumberTableEntry{
    private int startPc;
    private int lineNumber;
}