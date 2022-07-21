package com.geeksun.jvm.rtda;

public class Frame {
    private LocalVars localVars;
    private OperandStack operandStack;

    public Frame(int maxLocals, int maxStack){
        localVars = new LocalVars(maxLocals);
//        operandStack = new OperandStack(maxStack);
    }

}
