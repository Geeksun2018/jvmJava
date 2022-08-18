package com.geeksun.jvm;

import com.geeksun.jvm.classfile.ClassFile;
import com.geeksun.jvm.classfile.ConstantPool.MemberInfo;
import com.geeksun.jvm.classpath.Classpath;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.heap.Class;
import com.geeksun.jvm.rtda.heap.ClassLoader;
import com.geeksun.jvm.rtda.heap.Method;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            Cmd cmd = Cmd.parseCmd(args);
            if(cmd.isVersionFlag()){
                System.out.println("version 0.0.1");
            } else if (cmd.isHelpFlag()||cmd.getClassName().equals("")) {
                Cmd.printUsage(cmd);
            }else{
                startJVM(cmd);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ClassFile loadClass(String className, Classpath classpath){
        byte[] data = classpath.readClass(className);
        return new ClassFile(data);
    }

    public static void printClassInfo(ClassFile classFile){
        MemberInfo[] fields = classFile.getFields();
        System.out.printf("version: %s,%s\n", classFile.getMajorVersion(), classFile.getMinorVersion());
        System.out.printf("constants count: %d\n", classFile.getConstantPool().getFieldsCount());
        System.out.printf("access flags: %x\n", classFile.getAccessFlags());
        System.out.printf("this class: %s\n", classFile.getClassName());
        System.out.printf("super class: %s\n", classFile.getSuperClassName());
        System.out.printf("interfaces: %s\n", Arrays.toString(classFile.getInterfaceNames()));
        System.out.printf("fields count: %d\n", fields.length);
        for (MemberInfo field : fields) {
            System.out.printf("    %s\n", field.getName());
        }
        System.out.printf("methods count: %d\n", classFile.getMethods().length);
        for(MemberInfo memberInfo:classFile.getMethods()){
            System.out.printf("    %s\n", memberInfo.getName());
        }
    }

    public static MemberInfo getMainMethod(ClassFile classFile){
        for(MemberInfo memberInfo:classFile.getMethods()){
            if("main".equals(memberInfo.getName())&&"([Ljava/lang/String;)V".equals(memberInfo.getDescriptor())){
                return memberInfo;
            }
        }
        return null;
    }

    public static void startJVM(Cmd cmd){
        Classpath cp = new Classpath(cmd.getXjreOption(), cmd.getCpOption());
        String className = cmd.getClassName().replace(".", "/");
        ClassLoader classLoader = new ClassLoader(cp);
        Class mainClass = classLoader.loadClass(className);
        Method mainMethod = mainClass.getMainMethod();
        Interpreter interpreter = new Interpreter();
        if(mainMethod != null){
            interpreter.interpret(mainMethod);
        }else{
            System.out.println("Main method not found");
        }
//
//        Interpreter interpreter = new Interpreter();
//        if(mainMethod == null){
//            System.out.println("null main method");
//        }else{
//            interpreter.interpret(mainMethod);
//        }

    }



}
