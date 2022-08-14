package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.rtda.Frame;

public class IaLoad extends Index8Instruction {
    public int getOpCode(){
        return 0x2e;
    }

    @Override
    public void execute(Frame frame) {

    }
}
