package com.geeksun.jvm.instructions.base;

import com.geeksun.jvm.rtda.Frame;

public abstract class NoOperandsInstruction implements Instruction{

    @Override
    public void fetchOperands(BytecodeReader reader) {

    }

    @Override
    public abstract void execute(Frame frame);
}
