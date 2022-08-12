package com.geeksun.jvm.instructions.extended;

import com.geeksun.jvm.instructions.base.BranchInstruction;
import com.geeksun.jvm.instructions.base.BytecodeReader;
import com.geeksun.jvm.rtda.Frame;

public class GotoW extends BranchInstruction {
    @Override
    public int getOpCode() {
        return 0xc8;
    }

    @Override
    public void fetchOperands(BytecodeReader reader) {
        offset = reader.readUint32();
    }

    @Override
    public void execute(Frame frame) {
        branch(frame, offset);
    }
}
