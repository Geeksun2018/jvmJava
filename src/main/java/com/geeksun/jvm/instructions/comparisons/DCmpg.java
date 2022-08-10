package com.geeksun.jvm.instructions.comparisons;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;

public class DCmpg extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x98;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        double v2 = stack.popDouble();
        double v1 = stack.popDouble();
        if(v1 > v2){
            stack.pushInt(1);
        }else if(v1 == v2){
            stack.pushInt(0);
        }else if(v1 < v2){
            stack.pushInt(-1);
        }else{
            stack.pushInt(1);
        }
    }
}
