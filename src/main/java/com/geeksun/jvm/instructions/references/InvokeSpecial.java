package com.geeksun.jvm.instructions.references;

import com.geeksun.jvm.instructions.base.Index16Instruction;
import com.geeksun.jvm.rtda.Frame;

public class InvokeSpecial extends Index16Instruction {
    @Override
    public int getOpCode() {
        return 0xb7;
    }

    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().popRef();
    }
}
