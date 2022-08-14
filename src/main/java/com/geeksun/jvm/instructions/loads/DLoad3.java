package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.rtda.Frame;

public class DLoad3 extends Index8Instruction {
    public int getOpCode(){
        return 0x29;
    }

    @Override
    public void execute(Frame frame) {
        double val = frame.getLocalVars().getDouble(3);
        frame.getOperandStack().pushDouble(val);
    }
}
