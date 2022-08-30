package com.geeksun.jvm.classfile;

import com.geeksun.jvm.classfile.Attributes.AttributeInfo;
import com.geeksun.jvm.classfile.ConstantPool.ConstantInfo;
import com.geeksun.jvm.classfile.ConstantPool.ConstantPool;
import com.geeksun.jvm.classfile.ConstantPool.MemberInfo;
import lombok.Getter;

@Getter
public class ClassFile {

//    private int magic;
    private int minorVersion;
    private int majorVersion;
    private ConstantPool constantPool;
    private int accessFlags;
    private int thisClass;
    private int superClass;
    private int[] interfaces;
    private MemberInfo[] fields;
    private MemberInfo[] methods;
    private AttributeInfo[] attributes;


    public ClassFile(byte[] classData){
        ClassReader classReader = new ClassReader(classData);
        readAndCheckMagic(classReader);
        readAndCheckVersion(classReader);
        this.constantPool = new ConstantPool(classReader);
        this.accessFlags = classReader.nextU2toInteger();
        this.thisClass = classReader.nextU2toInteger();
        this.superClass = classReader.nextU2toInteger();
        this.interfaces = classReader.nextUint16s();
        this.fields = MemberInfo.readMembers(classReader, constantPool);
        this.methods = MemberInfo.readMembers(classReader, constantPool);
        this.attributes = AttributeInfo.readAttributes(classReader, constantPool);
    }


    private void readAndCheckVersion(ClassReader classReader) {
        this.minorVersion = classReader.nextU2toInteger();
        this.majorVersion = classReader.nextU2toInteger();
        switch (this.majorVersion){
             case 45:
                 break;
             case 46:
             case 47:
             case 48:
             case 49:
             case 50:
             case 51:
             case 52:
                 if(this.minorVersion == 0){
                     return;
                 }

        }
        System.out.println("java.lang.UnsupportedClassVersionError!");
    }

    public void readAndCheckMagic(ClassReader classReader){
        String magic = classReader.nextU4ToHexString();
        if(!"cafebabe".equals(magic)) {
            System.out.println("java.lang.classFormatError: magic!");
        }
    }

    public String getClassName(){
        return constantPool.getClassName(this.thisClass);
    }

    public String getSuperClassName(){
        if(this.superClass > 0){
            return constantPool.getClassName(this.superClass);
        }
        return "";
    }

    public String[] getInterfaceNames(){
        String[] names = new String[this.interfaces.length];
        for(int i = 0;i < interfaces.length;i++){
            names[i] = constantPool.getClassName(interfaces[i]);
        }
        return names;
    }




}
