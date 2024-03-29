package com.geeksun.jvm.instructions.comparisons;

import com.geeksun.jvm.instructions.base.BranchInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;

import java.util.Objects;

public class If_acmpne extends BranchInstruction {
    @Override
    public int getOpCode() {
        return 0xa6;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        Object ref2 = stack.popRef();
        Object ref1 = stack.popRef();
        if(!Objects.equals(ref2, ref1)){
            branch(frame, offset);
        }
    }
}
