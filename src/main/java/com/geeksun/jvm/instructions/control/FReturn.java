package com.geeksun.jvm.instructions.control;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class FReturn extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0xae;
    }

    @Override
    public void execute(Frame frame) {

    }
}
