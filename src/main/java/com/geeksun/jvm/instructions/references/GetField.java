package com.geeksun.jvm.instructions.references;

import com.geeksun.jvm.instructions.base.Index16Instruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.LocalVars;
import com.geeksun.jvm.rtda.OperandStack;
import com.geeksun.jvm.rtda.heap.ConstantPool;
import com.geeksun.jvm.rtda.heap.Field;
import com.geeksun.jvm.rtda.heap.FieldRef;
import com.geeksun.jvm.rtda.heap.Object;

public class GetField extends Index16Instruction {
    @Override
    public int getOpCode() {
        return 0xb4;
    }

    @Override
    public void execute(Frame frame) {
        ConstantPool constantPool = frame.getMethod().getClassMember().get_class().getConstantPool();
        FieldRef fieldRef = (FieldRef) constantPool.getConstant(index);
        Field field = fieldRef.resolveField();

        if(field.getClassMember().isStatic()){
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        OperandStack stack = frame.getOperandStack();
        Object ref = stack.popRef();
        if(ref == null){
            System.out.println("java.lang.NullPointerException");
        }
        String descriptor = field.getClassMember().getDescriptor();
        int slotId = field.getSlotId();
        assert ref != null;
        LocalVars slots = ref.getFields();
        switch (descriptor.charAt(0)){
            case 'Z':
            case 'B':
            case 'C':
            case 'S':
            case 'I':
                stack.pushInt(slots.getInt(slotId));
                break;
            case 'F':
                stack.pushFloat(slots.getFloat(slotId));
                break;
            case 'J':
                stack.pushLong(slots.getLong(slotId));
                break;
            case 'D':
                stack.pushDouble(slots.getDouble(slotId));
                break;
            case 'L':
            case '[':
                stack.pushRef(slots.getRef(slotId));
            default:
                // todo
        }
    }
}
