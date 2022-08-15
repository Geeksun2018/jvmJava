package com.geeksun.jvm.instructions.stores;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class FStore0 extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x43;
    }

    @Override
    public void execute(Frame frame) {
        float val = frame.getOperandStack().popFloat();
        frame.getLocalVars().setRef(0, val);
    }
}
