package com.geeksun.jvm.instructions.constants;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class DConst1 extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x0f;
    }

    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushDouble(1.0d);
    }
}
