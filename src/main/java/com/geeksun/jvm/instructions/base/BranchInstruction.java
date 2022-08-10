package com.geeksun.jvm.instructions.base;

import com.geeksun.jvm.rtda.Frame;

public abstract class BranchInstruction implements Instruction{
    protected int offset;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        offset = reader.readUint16();
    }

    @Override
    public abstract void execute(Frame frame);

    public void branch(Frame frame, int offset){
        int pc = frame.getThread().getPc();
        frame.setNextPc(pc);
    }
}