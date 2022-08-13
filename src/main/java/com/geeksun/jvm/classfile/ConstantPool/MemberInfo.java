package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.Attributes.AttributeInfo;
import com.geeksun.jvm.classfile.Attributes.CodeAttribute;
import com.geeksun.jvm.classfile.ClassReader;

import static com.geeksun.jvm.classfile.Attributes.AttributeInfo.readAttributes;

public class MemberInfo {

    private ConstantPool cp;
    private int accessFlags;
    private int nameIndex;
    private int descriptorIndex;
    private AttributeInfo[] attributeInfos;

    public MemberInfo(ClassReader classReader, ConstantPool constantPool){
        cp = constantPool;
        accessFlags = classReader.nextU2toInteger();
        nameIndex = classReader.nextU2toInteger();
        descriptorIndex = classReader.nextU2toInteger();
        attributeInfos = readAttributes(classReader, constantPool);
    }

    public static MemberInfo[] readMembers(ClassReader classReader, ConstantPool constantPool){
        int memberCount = classReader.nextU2toInteger();
        MemberInfo[] memberInfos = new MemberInfo[memberCount];
        for(int i = 0;i < memberCount;i++){
            memberInfos[i] = new MemberInfo(classReader, constantPool);
        }
        return memberInfos;
    }

    public String getName(){
        return cp.getUtf8(nameIndex);
    }

    public CodeAttribute getCodeAttribute(){
        for(AttributeInfo attributeInfo:attributeInfos){
            if(attributeInfo instanceof CodeAttribute){
                return (CodeAttribute) attributeInfo;
            }
        }
        return null;
    }

}
