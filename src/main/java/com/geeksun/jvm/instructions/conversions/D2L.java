package com.geeksun.jvm.instructions.conversions;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;

public class D2L extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x8f;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        stack.pushLong((long) stack.popDouble());
    }
}