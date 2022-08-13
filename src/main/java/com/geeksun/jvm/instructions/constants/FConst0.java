package com.geeksun.jvm.instructions.constants;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class FConst0 extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x0b;
    }

    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushFloat(0.0f);
    }
}
