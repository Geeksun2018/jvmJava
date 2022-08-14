package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.rtda.Frame;

public class XaLoad extends Index8Instruction {
    @Override
    public int getOpCode() {
        return 0;
    }

    @Override
    public void execute(Frame frame) {

    }
}
