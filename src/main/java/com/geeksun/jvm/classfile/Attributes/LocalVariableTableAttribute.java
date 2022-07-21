package com.geeksun.jvm.classfile.Attributes;

import com.geeksun.jvm.classfile.ClassReader;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class LocalVariableTableAttribute implements AttributeInfo {
    private LocalVariableTableEntry[] localVariableTable;

    public LocalVariableTableAttribute(ClassReader classReader){
        int localVariableTableLength = classReader.nextU2toInteger();
        localVariableTable = new LocalVariableTableEntry[localVariableTableLength];
        for(int i = 0;i < localVariableTableLength;i++){
            localVariableTable[i] = new LocalVariableTableEntry(classReader.nextU2toInteger(), classReader.nextU2toInteger(), classReader.nextU2toInteger(), classReader.nextU2toInteger(), classReader.nextU2toInteger());
        }
    }

}

@Getter
@AllArgsConstructor
class LocalVariableTableEntry{
    private int startPc;
    private int length;
    private int nameIndex;
    private int descriptorIndex;
    private int index;
}
