package com.geeksun.jvm.instructions.math;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;

public class LDiv extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x6d;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        long v2 = stack.popLong();
        long v1 = stack.popLong();
        if(v2 == 0){
            System.out.println("java.lang.ArithmeticException: by zero");
        }
        stack.pushLong(v1 / v2);
    }
}
