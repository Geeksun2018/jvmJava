package com.geeksun.jvm.instructions.loads;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.heap.Object;

public class ALoad1 extends NoOperandsInstruction {
    public int getOpCode(){
        return 0x2b;
    }

    @Override
    public void execute(Frame frame) {
        Object ref = frame.getLocalVars().getRef(1);
        frame.getOperandStack().pushRef(ref);
    }
}
