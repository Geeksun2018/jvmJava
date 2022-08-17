package com.geeksun.jvm.instructions.references;

import com.geeksun.jvm.instructions.base.Index16Instruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.LocalVars;
import com.geeksun.jvm.rtda.OperandStack;
import com.geeksun.jvm.rtda.heap.*;
import com.geeksun.jvm.rtda.heap.Class;
import com.geeksun.jvm.rtda.heap.Object;

public class PutField extends Index16Instruction {
    @Override
    public int getOpCode() {
        return 0xb5;
    }

    @Override
    public void execute(Frame frame) {
        Method currentMethod = frame.getMethod();
        Class currentClass = currentMethod.getClassMember().get_class();
        ConstantPool constantPool = currentClass.getConstantPool();
        FieldRef fieldRef = (FieldRef) constantPool.getConstant(index);
        Field field = fieldRef.resolveField();

        if(field.getClassMember().isStatic()){
            System.out.println(("java.lang.IncompatibleClassChangeError"));
        }
        if(field.getClassMember().isFinal()){
            if(currentClass != field.getClassMember().get_class() || !currentMethod.getClassMember().getName().equals("<init>")){
                System.out.println("java.lang.IllegalAccessError");
            }
        }
        String descriptor = field.getClassMember().getDescriptor();
        int slotId = field.getSlotId();
        OperandStack stack = frame.getOperandStack();

        switch (descriptor.charAt(0)){
            case 'Z':
            case 'B':
            case 'C':
            case 'S':
            case 'I':
                int intVal = stack.popInt();
                Object ref = stack.popRef();
                if(ref == null){
                    System.out.println("java.lang.NullPointerException");
                }
                assert ref != null;
                ref.getFields().setInt(slotId, intVal);
                break;
            case 'F':
                float floatVal = stack.popFloat();
                Object ref1 = stack.popRef();
                if(ref1 == null){
                    System.out.println("java.lang.NullPointerException");
                }
                assert ref1 != null;
                ref1.getFields().setFloat(slotId, floatVal);
                break;
            case 'J':
                long longVal = stack.popLong();
                Object ref2 = stack.popRef();
                if(ref2 == null){
                    System.out.println("java.lang.NullPointerException");
                }
                assert ref2 != null;
                ref2.getFields().setLong(slotId, longVal);
                break;
            case 'D':
                double doubleVal = stack.popDouble();
                Object ref3 = stack.popRef();
                if(ref3 == null){
                    System.out.println("java.lang.NullPointerException");
                }
                assert ref3 != null;
                ref3.getFields().setDouble(slotId, doubleVal);
                break;
            case 'L':
            case '[':
                Object refVal = stack.popRef();
                Object ref4 = stack.popRef();
                if(ref4 == null){
                    System.out.println("java.lang.NullPointerException");
                }
                assert ref4 != null;
                ref4.getFields().setRef(slotId, refVal);
                break;
            default:
                break;
        }

    }
}
