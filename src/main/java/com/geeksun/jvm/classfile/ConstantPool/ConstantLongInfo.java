package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;
import lombok.Getter;

@Getter
public class ConstantLongInfo implements ConstantInfo{
    private long val;

    public ConstantLongInfo(ClassReader classReader){
        val = classReader.next2U4ToLong();
    }


    @Override
    public String getInfo() {
        return String.valueOf(val);
    }
}
