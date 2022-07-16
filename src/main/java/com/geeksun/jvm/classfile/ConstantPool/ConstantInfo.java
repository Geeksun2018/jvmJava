package com.geeksun.jvm.classfile.ConstantPool;

import com.geeksun.jvm.classfile.ClassReader;
import com.sun.org.apache.bcel.internal.classfile.ConstantInterfaceMethodref;

public interface ConstantInfo {
    int CONSTANT_Class = 7;

    int CONSTANT_FieldRef = 9;

    int CONSTANT_MethodRef = 10;

    int CONSTANT_InterfaceMethodRef = 11;

    int CONSTANT_String = 8;

    int CONSTANT_Integer = 3;

    int CONSTANT_Float = 4;

    int CONSTANT_Long = 5;

    int CONSTANT_Double = 6;

    int CONSTANT_NameAndType = 12;

    int CONSTANT_Utf8 = 1;

    int CONSTANT_MethodHandle = 15;

    int CONSTANT_MethodType = 16;

    int CONSTANT_InvokeDynamic = 18;

    String getInfo();

    public static ConstantInfo readConstantInfo(ClassReader classReader, ConstantPool constantPool){
        int tag = classReader.nextU1toInteger();
        return newConstantInfo(tag, constantPool, classReader);
    }

    public static ConstantInfo newConstantInfo(int tag, ConstantPool constantPool, ClassReader classReader){
        switch (tag){
            case CONSTANT_Integer:
                return new ConstantIntegerInfo(classReader);
            case CONSTANT_Float:
                return new ConstantFloatInfo(classReader);
            case CONSTANT_Long:
                return new ConstantLongInfo(classReader);
            case CONSTANT_Double:
                return new ConstantDoubleInfo(classReader);
            case CONSTANT_Utf8:
                return new ConstantUTF8Info(classReader);
            case CONSTANT_String:
                return new ConstantStringInfo(classReader);
            case CONSTANT_Class:
                return new ConstantClassInfo(classReader);
            case CONSTANT_FieldRef:
                return new ConstantFieldRefInfo(classReader);
            case  CONSTANT_MethodRef:
                return new ConstantMethodRefInfo(classReader);
            case CONSTANT_InterfaceMethodRef:
                return new ConstantInterfaceMethodRefInfo(classReader);
            case CONSTANT_NameAndType:
                return new ConstantNameAndTypeInfo(classReader);
//            case CONSTANT_MethodType:
//                return new ConstantMethod
            default:
                return null;
        }

    }

}
