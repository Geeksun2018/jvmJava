package com.geeksun.jvm.instructions.constants;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;


public class LdcW extends NoOperandsInstruction {

    @Override
    public int getOpCode() {
        return 0x13;
    }

    @Override
    public void execute(Frame frame) {

    }
}
