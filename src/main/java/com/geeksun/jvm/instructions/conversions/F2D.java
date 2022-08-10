package com.geeksun.jvm.instructions.conversions;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;

public class F2D extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x8f;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        stack.pushDouble((double) stack.popFloat());
    }
}
