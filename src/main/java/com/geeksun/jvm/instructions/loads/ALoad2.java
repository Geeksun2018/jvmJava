package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.rtda.Frame;

public class ALoad2 extends Index8Instruction {
    public int getOpCode(){
        return 0x2c;
    }

    @Override
    public void execute(Frame frame) {
        Object ref = frame.getLocalVars().getRef(2);
        frame.getOperandStack().pushRef(ref);
    }
}
