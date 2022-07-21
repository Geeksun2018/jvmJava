package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;
import lombok.Getter;

@Getter
public class ConstantNameAndTypeInfo implements ConstantInfo{
    private int nameIndex;
    private int descriptorIndex;

    public ConstantNameAndTypeInfo(ClassReader classReader){
        this.nameIndex = classReader.nextU2toInteger();
        this.descriptorIndex = classReader.nextU2toInteger();
    }


    @Override
    public String getInfo() {
        return null;
    }
}
