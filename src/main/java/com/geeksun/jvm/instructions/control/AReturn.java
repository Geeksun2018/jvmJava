package com.geeksun.jvm.instructions.control;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.Thread;
import com.geeksun.jvm.rtda.heap.Object;

public class AReturn extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0xb0;
    }

    @Override
    public void execute(Frame frame) {
        Thread thread = frame.getThread();
        Frame currentFrame = thread.popFrame();
        Frame invokeFrame = thread.currentFrame();
        Object ref = currentFrame.getOperandStack().popRef();
        invokeFrame.getOperandStack().pushRef(ref);
    }
}
