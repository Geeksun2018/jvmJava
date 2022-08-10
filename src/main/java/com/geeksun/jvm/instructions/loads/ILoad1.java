package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.rtda.Frame;

public class ILoad1 extends Index8Instruction {
    public int getOpCode(){
        return 0x1f;
    }

    @Override
    public void execute(Frame frame) {
        long val = frame.getLocalVars().getLong(1);
        frame.getOperandStack().pushLong(val);
    }
}
