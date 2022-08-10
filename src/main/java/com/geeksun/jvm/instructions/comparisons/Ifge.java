package com.geeksun.jvm.instructions.comparisons;

import com.geeksun.jvm.instructions.base.BranchInstruction;
import com.geeksun.jvm.rtda.Frame;

public class Ifge extends BranchInstruction {
    @Override
    public int getOpCode() {
        return 0x9d;
    }

    @Override
    public void execute(Frame frame) {
        int val = frame.getOperandStack().popInt();
        if(val >= 0){
            branch(frame, offset);
        }
    }
}
