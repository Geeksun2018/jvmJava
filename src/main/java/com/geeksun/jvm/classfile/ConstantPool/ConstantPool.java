package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;

public class ConstantPool {

    private ConstantInfo[] constantInfos;

    public ConstantPool(ClassReader classReader){
        int cpCount = classReader.nextU2toInteger();
        constantInfos = new ConstantInfo[cpCount];
        // The constant_pool table is indexed from 1 to constant_pool_count - 1.
        for(int i = 1;i < cpCount;i++){
            constantInfos[i] = ConstantInfo.readConstantInfo(classReader, this);
            if(constantInfos[i] instanceof ConstantLongInfo||constantInfos[i] instanceof ConstantDoubleInfo){
                i++;
            }
        }
    }

    public ConstantInfo getConstantInfo(int index){
        ConstantInfo constantInfo = constantInfos[index];
        if(constantInfo != null){
            return constantInfo;
        }
        System.out.println("Invalid constant poll index");
        return null;
    }

    public String getUtf8(int index){
        ConstantUTF8Info info = (ConstantUTF8Info) getConstantInfo(index);
        return info.getStr();
    }

    public String getClassName(int index){
        ConstantClassInfo constantClassInfo = (ConstantClassInfo) getConstantInfo(index);
        return getUtf8(constantClassInfo.getNameIndex());
    }

    public String getNameAndType(int index){
        ConstantNameAndTypeInfo info = (ConstantNameAndTypeInfo) getConstantInfo(index);
        String name = getUtf8(info.getNameIndex());
        String type = getUtf8(info.getDescriptorIndex());
        return name + " " + type;
    }

    public int getFieldsCount(){
        return constantInfos.length;
    }

}
