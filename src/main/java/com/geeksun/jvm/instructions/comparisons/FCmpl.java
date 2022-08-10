package com.geeksun.jvm.instructions.comparisons;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;

public class FCmpl extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x95;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        float v2 = stack.popFloat();
        float v1 = stack.popFloat();
        if(v1 > v2){
            stack.pushInt(1);
        }else if(v1 == v2){
            stack.pushInt(0);
        }else if(v1 < v2){
            stack.pushInt(-1);
        }else{
            stack.pushInt(-1);
        }
    }
}
