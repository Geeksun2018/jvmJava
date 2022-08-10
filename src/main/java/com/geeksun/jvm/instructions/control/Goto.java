package com.geeksun.jvm.instructions.control;

import com.geeksun.jvm.instructions.base.BranchInstruction;
import com.geeksun.jvm.instructions.base.BytecodeReader;
import com.geeksun.jvm.rtda.Frame;

public class Goto extends BranchInstruction {
    @Override
    public int getOpCode() {
        return 0xa7;
    }

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.offset = reader.readUint16();
    }

    @Override
    public void execute(Frame frame) {
        branch(frame, offset);
    }
}
