package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.rtda.Frame;

public class ALoad3 extends Index8Instruction {
    public int getOpCode(){
        return 0x2d;
    }

    @Override
    public void execute(Frame frame) {
        Object ref = frame.getLocalVars().getRef(3);
        frame.getOperandStack().pushRef(ref);
    }
}
