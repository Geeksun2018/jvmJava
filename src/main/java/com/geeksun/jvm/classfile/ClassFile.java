package com.geeksun.jvm.classfile;

import com.geeksun.jvm.classfile.Attributes.AttributeInfo;
import com.geeksun.jvm.classfile.ConstantPool.ConstantPool;
import com.geeksun.jvm.classfile.ConstantPool.MemberInfo;

public class ClassFile {

    private int magic;
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
        this.constantPool = readConstantPool(classReader);
    }

    private ConstantPool readConstantPool(ClassReader classReader) {
        return null;
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
        magic = classReader.nextU4toInteger();
        if(magic != 0xCAFEBABE) {
            System.out.println("java.lang.classFormatError: magic!");
        }
    }


}
