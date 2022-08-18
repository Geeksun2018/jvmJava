package com.geeksun.jvm.instructions.constants;

import com.geeksun.jvm.instructions.base.Index16Instruction;
import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;
import com.geeksun.jvm.rtda.heap.ConstantPool;


public class Ldc2W extends Index16Instruction {

    @Override
    public int getOpCode() {
        return 0x14;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        ConstantPool constantPool = frame.getMethod().getClassMember().get_class().getConstantPool();
        Object constant = constantPool.getConstant(index);
        if(constant instanceof Long){
            stack.pushLong((Long) constant);
        }else if(constant instanceof Float){
            stack.pushDouble((Double) constant);
        }else {
            System.out.println("java.lang.ClassFormatError");
        }
    }
}
