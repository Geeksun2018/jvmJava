package com.geeksun.jvm.instructions.base;

import com.geeksun.jvm.rtda.Frame;

public abstract class Index16Instruction implements Instruction {
    protected int index;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        index = reader.readInt16();
    }

    @Override
    public abstract void execute(Frame frame);
}