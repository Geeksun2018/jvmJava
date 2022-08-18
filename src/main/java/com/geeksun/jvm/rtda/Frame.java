package com.geeksun.jvm.rtda;

import com.geeksun.jvm.rtda.heap.Method;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Frame {

    private Frame lower;
    private LocalVars localVars;
    private OperandStack operandStack;
    private Thread thread;

    private Method method;

    private int nextPc;

    public Frame(Thread thread, Method method){
        this.thread =thread;
        this.method = method;
        localVars = new LocalVars(method.getMaxLocals());
        operandStack = new OperandStack(method.getMaxStack());
    }

}
