package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.heap.Object;

public class ALoad2 extends NoOperandsInstruction {
    public int getOpCode(){
        return 0x2c;
    }

    @Override
    public void execute(Frame frame) {
        Object ref = frame.getLocalVars().getRef(2);
        frame.getOperandStack().pushRef(ref);
    }
}
