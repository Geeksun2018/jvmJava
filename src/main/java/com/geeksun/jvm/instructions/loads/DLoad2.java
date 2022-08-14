package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.rtda.Frame;

public class DLoad2 extends Index8Instruction {
    public int getOpCode(){
        return 0x28;
    }

    @Override
    public void execute(Frame frame) {
        double val = frame.getLocalVars().getDouble(2);
        frame.getOperandStack().pushDouble(val);
    }
}
