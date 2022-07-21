package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;
import lombok.Getter;
@Getter
public class ConstantClassInfo implements ConstantInfo{
    private ConstantPool constantPool;
    private int nameIndex;

    public ConstantClassInfo(ClassReader classReader){
        this.nameIndex = classReader.nextU2toInteger();
    }

    @Override
    public String getInfo() {
        return null;
    }
}
