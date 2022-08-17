package com.geeksun.jvm.instructions.stores;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.rtda.Frame;

public class DStore0 extends Index8Instruction {
    @Override
    public int getOpCode() {
        return 0x47;
    }

    @Override
    public void execute(Frame frame) {
        double val = frame.getOperandStack().popDouble();
        frame.getLocalVars().setDouble(0, val);
    }
}
