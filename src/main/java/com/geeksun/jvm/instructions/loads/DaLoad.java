package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.rtda.Frame;

public class DaLoad extends Index8Instruction {
    public int getOpCode(){
        return 0x34;
    }

    @Override
    public void execute(Frame frame) {
    }
}
