package com.geeksun.jvm.instructions.base;

import com.geeksun.jvm.rtda.Frame;

public abstract class Index16Instruction implements Instruction {
    private int index;

    @Override
    public int getOpCode() {
        return 0;
    }

    @Override
    public void fetchOperands(BytecodeReader reader) {
        index = reader.readUint16();
    }

    @Override
    public void execute(Frame frame) {

    }
}