package com.geeksun.jvm.instructions.base;

import com.geeksun.jvm.rtda.Frame;

public interface Instruction {

    int getOpCode();

    default String getReName(){
        return this.getClass().getSimpleName();
    }

    void fetchOperands(BytecodeReader reader);

    void execute(Frame frame);

}

