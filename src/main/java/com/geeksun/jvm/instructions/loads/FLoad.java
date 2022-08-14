package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.rtda.Frame;

public class FLoad extends Index8Instruction {
    public int getOpCode(){
        return 0x17;
    }

    @Override
    public void execute(Frame frame) {
        float val = frame.getLocalVars().getFloat(index);
        frame.getOperandStack().pushFloat(val);
    }
}
