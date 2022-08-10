package com.geeksun.jvm.instructions.comparisons;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;

public class Lcmp extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x94;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        long v2 = stack.popLong();
        long v1 = stack.popLong();
        if(v1 < v2){
            stack.pushInt(1);
        }else if(v1 == v2){
            stack.pushInt(0);
        }else{
            stack.pushInt(-1);
        }
    }
}
