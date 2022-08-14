package com.geeksun.jvm.instructions.stores;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class AStore2 extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x4d;
    }

    @Override
    public void execute(Frame frame) {
        Object val = frame.getOperandStack().popRef();
        frame.getLocalVars().setRef(1, val);
    }
}
