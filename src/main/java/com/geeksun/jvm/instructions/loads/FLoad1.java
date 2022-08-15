package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class FLoad1 extends NoOperandsInstruction {
    public int getOpCode(){
        return 0x23;
    }

    @Override
    public void execute(Frame frame) {
        float val = frame.getLocalVars().getFloat(1);
        frame.getOperandStack().pushFloat(val);
    }
}
