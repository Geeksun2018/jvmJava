package com.geeksun.jvm.instructions.constants;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class IConst5 extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x08;
    }

    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushInt(5);
    }
}
