package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.rtda.Frame;

public class FLoad0 extends Index8Instruction {
    public int getOpCode(){
        return 0x22;
    }

    @Override
    public void execute(Frame frame) {
        float val = frame.getLocalVars().getFloat(0);
        frame.getOperandStack().pushFloat(val);
    }
}
