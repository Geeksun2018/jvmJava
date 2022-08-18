package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;
import lombok.Getter;
@Getter
public class ConstantClassInfo implements ConstantInfo{
    private ConstantPool constantPool;
    private int nameIndex;

    public ConstantClassInfo(ConstantPool constantPool, ClassReader classReader){
        this.constantPool = constantPool;
        this.nameIndex = classReader.nextU2toInteger();
    }

    @Override
    public String getInfo() {
        return null;
    }

    public String getName(){
        return constantPool.getUtf8(this.nameIndex);
    }

}
