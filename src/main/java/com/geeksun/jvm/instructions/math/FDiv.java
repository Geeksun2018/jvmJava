package com.geeksun.jvm.instructions.math;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;

public class FDiv extends NoOperandsInstruction {

    @Override
    public int getOpCode() {
        return 0x6e;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        float v2 = stack.popFloat();
        float v1 = stack.popFloat();
        if(v2 == 0){
            System.out.println("java.lang.ArithmeticException: by zero");
        }
        stack.pushFloat(v1 + v2);
    }

}
