package com.geeksun.jvm.instructions.constants;

import com.geeksun.jvm.instructions.base.Index16Instruction;
import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;
import com.geeksun.jvm.rtda.heap.ConstantPool;


public class LdcW extends Index16Instruction {

    @Override
    public int getOpCode() {
        return 0x13;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        ConstantPool constantPool = frame.getMethod().getClassMember().get_class().getConstantPool();
        Object constant = constantPool.getConstant(index);
        if(constant instanceof Integer){
            stack.pushInt((Integer) constant);
        }else if(constant instanceof Float){
            stack.pushFloat((Float) constant);
        }else if(constant instanceof String){
            System.out.println("to do");
        }else {
            System.out.println("to do ldc");
        }
    }
}
