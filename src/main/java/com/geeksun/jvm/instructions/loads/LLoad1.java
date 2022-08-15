package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class LLoad1 extends NoOperandsInstruction {
    public int getOpCode(){
        return 0x1f;
    }

    @Override
    public void execute(Frame frame) {
        long val = frame.getLocalVars().getLong(1);
        frame.getOperandStack().pushLong(val);
    }
}
