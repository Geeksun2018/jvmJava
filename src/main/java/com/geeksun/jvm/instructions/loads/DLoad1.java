package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class DLoad1 extends NoOperandsInstruction {
    public int getOpCode(){
        return 0x27;
    }

    @Override
    public void execute(Frame frame) {
        double val = frame.getLocalVars().getDouble(1);
        frame.getOperandStack().pushDouble(val);
    }
}
