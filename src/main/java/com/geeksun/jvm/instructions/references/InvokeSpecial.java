package com.geeksun.jvm.instructions.references;

import com.geeksun.jvm.instructions.base.BaseMethod;
import com.geeksun.jvm.instructions.base.Index16Instruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.heap.*;
import com.geeksun.jvm.rtda.heap.Class;
import com.geeksun.jvm.rtda.heap.Object;

import java.util.Objects;

public class InvokeSpecial extends Index16Instruction {
    @Override
    public int getOpCode() {
        return 0xb7;
    }

    @Override
    public void execute(Frame frame) {
        Class currentClass = frame.getMethod().getClassMember().get_class();
        ConstantPool cp = currentClass.getConstantPool();
        MethodRef methodRef = (MethodRef) cp.getConstant(index);
        Class resolvedClass = methodRef.getMemberRef().getSymRef().resolveClass();
        Method resolvedMethod = methodRef.resolveMethod();
        if(resolvedMethod.getClassMember().getName().equals("<init>")&&resolvedMethod.getClassMember().get_class() != resolvedClass){
            System.out.println("java.lang.NoSuchMethodError");
        }
        if(resolvedMethod.getClassMember().isStatic()){
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        Object ref = frame.getOperandStack().getRefFromTop(resolvedMethod.getArgSlotCount() - 1);
        if(ref == null){
            System.out.println("java.lang.NullPointerException");
        }
        if(resolvedMethod.getClassMember().isProtected()&&resolvedMethod.getClassMember().get_class().isSuperClassOf(currentClass)&&
        !resolvedMethod.getClassMember().get_class().getPackageName().equals(currentClass.getPackageName())&&
        Objects.requireNonNull(ref).get_class() != currentClass&&!ref.get_class().isSubClassOf(currentClass)){
            System.out.println("java.lang.IllegalAccessError");
        }
        Method methodToBeInvoked = resolvedMethod;
        if(currentClass.isSuper()&&resolvedClass.isSuperClassOf(currentClass)&&!resolvedMethod.getClassMember().getName().equals("<init>")){
            methodToBeInvoked = MethodLookup.lookupMethodInClass(currentClass.getSuperClass(), methodRef.getMemberRef().getName(), methodRef.getMemberRef().getDescriptor());
        }
        if(methodToBeInvoked == null||methodToBeInvoked.getClassMember().isAbstract()){
            System.out.println("java.lang.AbstractMethodError");
        }
        BaseMethod.invokeMethod(frame, methodToBeInvoked);
    }
}
