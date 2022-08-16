package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;
import lombok.Getter;

@Getter
public class ConstantFloatInfo implements ConstantInfo{

    private float val;

    public ConstantFloatInfo(ClassReader classReader){
        val = classReader.nextU4toFloat();
    }

    @Override
    public String getInfo() {
        return String.valueOf(val);
    }
}
