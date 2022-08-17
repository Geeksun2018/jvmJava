package com.geeksun.jvm.instructions.constants;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;
import com.geeksun.jvm.rtda.heap.ConstantPool;


public class Ldc extends NoOperandsInstruction {

    @Override
    public int getOpCode() {
        return 0x12;
    }

    @Override
    public void execute(Frame frame) {

    }

    public void _ldc(Frame frame, int index){
        OperandStack stack = frame.getOperandStack();
        ConstantPool constantPool = frame.getMethod().getClassMember().get_class().getConstantPool();
        Object constant = constantPool.getConstant(index);

    }

}
