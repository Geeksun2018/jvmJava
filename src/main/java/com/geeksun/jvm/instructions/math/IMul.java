package com.geeksun.jvm.instructions.math;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;

public class IMul extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x68;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        stack.pushFloat(v1 * v2);
    }
}
