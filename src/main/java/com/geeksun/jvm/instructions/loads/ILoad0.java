package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.rtda.Frame;

public class ILoad0 extends Index8Instruction {
    public int getOpCode(){
        return 0x1e;
    }

    @Override
    public void execute(Frame frame) {
        long val = frame.getLocalVars().getLong(0);
        frame.getOperandStack().pushLong(val);
    }
}
