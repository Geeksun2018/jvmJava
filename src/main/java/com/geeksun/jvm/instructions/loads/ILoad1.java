package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class ILoad1 extends NoOperandsInstruction {
    public int getOpCode(){
        return 0x1b;
    }

    @Override
    public void execute(Frame frame) {
        int val = frame.getLocalVars().getInt(1);
        frame.getOperandStack().pushInt(val);
    }
}
