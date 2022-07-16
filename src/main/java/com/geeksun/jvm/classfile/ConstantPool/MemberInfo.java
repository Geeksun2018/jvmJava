package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.Attributes.AttributeInfo;
import com.geeksun.jvm.classfile.ClassReader;

public class MemberInfo {

    private ConstantPool cp;
    private int accessFlags;
    private int nameIndex;
    private int descriptorIndex;
    private AttributeInfo[] attributeInfos;

    public MemberInfo(ClassReader classReader, ConstantPool constantPool){
        cp = constantPool;
        accessFlags = classReader.nextU4toInteger();
        nameIndex = classReader.nextU4toInteger();
        descriptorIndex = classReader.nextU4toInteger();
//        attributeInfos = readAttributes(classReader, constantPool);
    }

    public MemberInfo[] readMembers(ClassReader classReader, ConstantPool constantPool){
        int memberCount = classReader.nextU4toInteger();
        MemberInfo[] memberInfos = new MemberInfo[memberCount];
        for(int i = 0;i < memberCount;i++){
            memberInfos[i] = new MemberInfo(classReader, constantPool);
        }
        return memberInfos;
    }

}
