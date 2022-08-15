package com.geeksun.jvm.instructions.constants;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class AConstNull extends NoOperandsInstruction {

    @Override
    public int getOpCode() {
        return 0x01;
    }

    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushRef(null);
    }
    
}
