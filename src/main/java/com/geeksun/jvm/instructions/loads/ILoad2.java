package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class ILoad2 extends NoOperandsInstruction {
    public int getOpCode(){
        return 0x1c;
    }

    @Override
    public void execute(Frame frame) {
        int val = frame.getLocalVars().getInt(2);
        frame.getOperandStack().pushInt(val);
    }
}
