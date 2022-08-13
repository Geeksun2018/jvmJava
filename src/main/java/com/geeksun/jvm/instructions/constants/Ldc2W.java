package com.geeksun.jvm.instructions.constants;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;


public class Ldc2W extends NoOperandsInstruction {

    @Override
    public int getOpCode() {
        return 0x14;
    }

    @Override
    public void execute(Frame frame) {

    }
}
