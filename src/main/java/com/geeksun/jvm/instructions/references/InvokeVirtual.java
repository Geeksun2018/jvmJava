package com.geeksun.jvm.instructions.references;

import com.geeksun.jvm.instructions.base.BaseMethod;
import com.geeksun.jvm.instructions.base.Index16Instruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;
import com.geeksun.jvm.rtda.heap.*;
import com.geeksun.jvm.rtda.heap.Class;
import com.geeksun.jvm.rtda.heap.Object;

public class InvokeVirtual extends Index16Instruction {
    @Override
    public int getOpCode() {
        return 0xb6;
    }

    @Override
    public void execute(Frame frame) {
        Class currentClass = frame.getMethod().getClassMember().get_class();
        ConstantPool cp = currentClass.getConstantPool();
        MethodRef methodRef = (MethodRef) cp.getConstant(index);
        Method resolvedMethod = methodRef.resolveMethod();
        if(resolvedMethod.getClassMember().isStatic()){
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        Object ref = frame.getOperandStack().getRefFromTop(resolvedMethod.getArgSlotCount() - 1);
        if(ref == null){
            if(methodRef.getMemberRef().getName().equals("println")){
                _println(frame.getOperandStack(), methodRef.getMemberRef().getDescriptor());
                return;
            }
            System.out.println("java.lang.NullPointerException");
        }
        assert ref != null;
        if(resolvedMethod.getClassMember().isProtected()&&resolvedMethod.getClassMember().get_class().isSuperClassOf(currentClass)&&
        !resolvedMethod.getClassMember().get_class().getPackageName().equals(currentClass.getPackageName())&&ref.get_class()!=currentClass&&
        !ref.get_class().isSubClassOf(currentClass)){
            System.out.println("java.lang.IllegalAccessError");
        }
        Method methodToBeInvoked = MethodLookup.lookupMethodInClass(ref.get_class(),methodRef.getMemberRef().getName(),methodRef.getMemberRef().getDescriptor());
        if(methodToBeInvoked == null||methodToBeInvoked.getClassMember().isAbstract()){
            System.out.println("java.lang.AbstractMethodError");
        }
        BaseMethod.invokeMethod(frame, methodToBeInvoked);
    }

    private void _println(OperandStack stack, String descriptor) {
        switch (descriptor){
            case "Z(V)":
                System.out.println(stack.popInt() != 0);
                break;
            case "(C)V":
            case "(B)V":
            case "(S)V":
            case "(I)V":
                System.out.print("   res:   " +  stack.popInt());
                break;
            case "(J)V":
                System.out.println(stack.popLong());
                break;
            case "(F)V":
                System.out.println(stack.popFloat());
                break;
            case "(D)V":
                System.out.println(stack.popDouble());
                break;
            default:
                System.out.println("println: " + descriptor);
        }
        stack.popRef();
    }
}
