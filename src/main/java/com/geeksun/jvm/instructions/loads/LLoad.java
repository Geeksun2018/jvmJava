package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.rtda.Frame;

public class LLoad extends Index8Instruction {
    public int getOpCode(){
        return 0x16;
    }

    @Override
    public void execute(Frame frame) {
        long val = frame.getLocalVars().getLong(index);
        frame.getOperandStack().pushLong(val);
    }
}
