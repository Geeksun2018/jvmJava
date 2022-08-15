package com.geeksun.jvm.instructions.stores;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class DStore2 extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x48;
    }

    @Override
    public void execute(Frame frame) {
        double val = frame.getOperandStack().popDouble();
        frame.getLocalVars().setRef(2, val);
    }
}
