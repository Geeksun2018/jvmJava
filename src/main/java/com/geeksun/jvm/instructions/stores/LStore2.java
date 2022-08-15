package com.geeksun.jvm.instructions.stores;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class LStore2 extends NoOperandsInstruction {

    public int getOpCode(){
        return 0x41;
    }

    @Override
    public void execute(Frame frame) {
        long val = frame.getOperandStack().popLong();
        frame.getLocalVars().setLong(2, val);
    }
}
