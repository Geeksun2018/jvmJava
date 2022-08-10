package com.geeksun.jvm.instructions.math;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;

public class FNeg extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x76;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        stack.pushFloat(stack.popFloat() * -1);
    }
}
