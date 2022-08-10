package com.geeksun.jvm.instructions.math;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;

public class IShr extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x7a;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        // int只有32位，取前五位就足够了
        int s = v2 & 0x1f;
        stack.pushInt(v1 >> s);
    }
}
