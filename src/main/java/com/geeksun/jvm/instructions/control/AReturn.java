package com.geeksun.jvm.instructions.control;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.Thread;

public class AReturn extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0xb0;
    }

    @Override
    public void execute(Frame frame) {
        Thread thread = frame.getThread();
    }
}
