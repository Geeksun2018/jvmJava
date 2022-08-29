package com.geeksun.jvm.instructions.control;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class Return extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0xb1;
    }

    @Override
    public void execute(Frame frame) {
        frame.getThread().popFrame();
    }


}
