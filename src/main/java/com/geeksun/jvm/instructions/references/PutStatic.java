package com.geeksun.jvm.instructions.references;

import com.geeksun.jvm.instructions.base.Index16Instruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.LocalVars;
import com.geeksun.jvm.rtda.OperandStack;
import com.geeksun.jvm.rtda.heap.*;
import com.geeksun.jvm.rtda.heap.Class;

public class PutStatic extends Index16Instruction {
    @Override
    public int getOpCode() {
        return 0xb3;
    }

    @Override
    public void execute(Frame frame) {
        Method currentMethod = frame.getMethod();
        Class currentClass = currentMethod.getClassMember().get_class();
        ConstantPool constantPool = currentClass.getConstantPool();
        FieldRef fieldRef = (FieldRef) constantPool.getConstant(index);
        Field field = fieldRef.resolveField();
        Class aClass = field.getClassMember().get_class();
        if(!field.getClassMember().isStatic()){
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        if(field.getClassMember().isFinal()){
            if(currentClass != aClass||currentMethod.getClassMember().getName().equals("<clinit>")){
                System.out.println("java.lang.IllegalAccessError");
            }
        }
        String descriptor = field.getClassMember().getDescriptor();
        int slotId = field.getSlotId();
        LocalVars slots = aClass.getStaticVars();
        OperandStack stack = frame.getOperandStack();
        switch (descriptor.charAt(0)){
            case 'Z':
            case 'B':
            case 'C':
            case 'S':
            case 'I':
                slots.setInt(slotId, stack.popInt());
                break;
            case 'F':
                slots.setFloat(slotId, stack.popFloat());
                break;
            case 'J':
                slots.setLong(slotId, stack.popLong());
                break;
            case 'D':
                slots.setDouble(slotId, stack.popDouble());
                break;
            case 'L':
            case '[':
                slots.setRef(slotId, stack.popRef());
                break;
            default:
                break;
        }


    }
}
