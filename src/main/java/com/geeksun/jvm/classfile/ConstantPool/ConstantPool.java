package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;

public class ConstantPool {

    private ConstantInfo[] constantInfos;

    public ConstantPool(ClassReader classReader){
        int cpCount = classReader.nextU2toInteger();
        constantInfos = new ConstantInfo[cpCount];
        for(int i = 0;i < cpCount;i++){
            constantInfos[i] = ConstantInfo.readConstantInfo(classReader, this);
            if(constantInfos[i] instanceof ConstantLongInfo||constantInfos[i] instanceof ConstantDoubleInfo){
                i++;
            }
        }
    }

}
