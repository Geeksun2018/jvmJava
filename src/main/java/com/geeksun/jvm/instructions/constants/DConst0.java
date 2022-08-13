package com.geeksun.jvm.instructions.constants;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class DConst0 extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x0e;
    }

    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushDouble(0.0);
    }
}
