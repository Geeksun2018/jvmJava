package com.geeksun.jvm.instructions.stores;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class IStore2 extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x3d;
    }

    @Override
    public void execute(Frame frame) {
        int val = frame.getOperandStack().popInt();
        frame.getLocalVars().setRef(2, val);
    }
}
