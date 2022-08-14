package com.geeksun.jvm.instructions.control;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class Jsr extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0xa8;
    }

    @Override
    public void execute(Frame frame) {

    }
}
