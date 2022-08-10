package com.geeksun.jvm.instructions.math;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;

public class IDiv extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x6c;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        if(v2 == 0){
            System.out.println("java.lang.ArithmeticException: by zero");
        }
        stack.pushInt(v1 / v2);
    }
}
