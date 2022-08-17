package com.geeksun.jvm.instructions.stores;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.heap.Object;

public class AStore extends Index8Instruction {
    @Override
    public int getOpCode() {
        return 0x3a;
    }

    @Override
    public void execute(Frame frame) {
        Object reference = frame.getOperandStack().popRef();
        frame.getLocalVars().setRef(index, reference);
    }
}
