package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.rtda.Frame;

public class DLoad0 extends Index8Instruction {
    public int getOpCode(){
        return 0x26;
    }

    @Override
    public void execute(Frame frame) {
        double val = frame.getLocalVars().getDouble(0);
        frame.getOperandStack().pushDouble(val);
    }
}
