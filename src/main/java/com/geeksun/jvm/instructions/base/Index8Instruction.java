package com.geeksun.jvm.instructions.base;

import com.geeksun.jvm.rtda.Frame;

public abstract class Index8Instruction implements Instruction {
    protected int index;


    @Override
    public void fetchOperands(BytecodeReader reader) {
        index = reader.readUint8();
    }

    @Override
    public void execute(Frame frame) {

    }
}