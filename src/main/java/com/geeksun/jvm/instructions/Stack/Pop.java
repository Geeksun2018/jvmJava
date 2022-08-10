package com.geeksun.jvm.instructions.Stack;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class Pop extends NoOperandsInstruction {

    public int getOpCode(){
        return 0x57;
    }

    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().popSlot();
    }
}
