package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;
import lombok.Getter;

@Getter
public class ConstantDoubleInfo implements ConstantInfo{
    private double val;

    public ConstantDoubleInfo(ClassReader classReader){
        val = classReader.next2U4ToDouble();
    }

    @Override
    public String getInfo() {
        return String.valueOf(val);
    }
}
