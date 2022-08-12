package com.geeksun.jvm.instructions.extended;

import com.geeksun.jvm.instructions.base.BranchInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;

public class IfNull extends BranchInstruction {
    @Override
    public int getOpCode() {
        return 0xc6;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        Object object = stack.popRef();
        if(object == null){
            branch(frame, offset);
        }

    }
}
