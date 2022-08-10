package com.geeksun.jvm.instructions.math;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;

public class LUShr extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x7d;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        long v2 = stack.popInt();
        long v1 = stack.popInt();
        // int只有32位，取前五位就足够了
        long s = v2 & 0x3f;
        stack.pushLong(v1 >>> s);
    }
}
