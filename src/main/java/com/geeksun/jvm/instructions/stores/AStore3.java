package com.geeksun.jvm.instructions.stores;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.heap.Object;

public class AStore3 extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x4e;
    }

    @Override
    public void execute(Frame frame) {
        Object val = frame.getOperandStack().popRef();
        frame.getLocalVars().setRef(3, val);
    }
}
