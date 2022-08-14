package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.rtda.Frame;

public class SaLoad extends Index8Instruction {
    @Override
    public int getOpCode() {
        return 0x35;
    }

    @Override
    public void execute(Frame frame) {

    }
}
