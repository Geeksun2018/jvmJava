package com.geeksun.jvm.instructions.control;

import com.geeksun.jvm.instructions.base.BranchInstruction;
import com.geeksun.jvm.instructions.base.BytecodeReader;
import com.geeksun.jvm.rtda.Frame;

public class TableSwitch extends BranchInstruction {



    @Override
    public int getOpCode() {
        return 0xaa;
    }

    @Override
    public void fetchOperands(BytecodeReader reader) {
        reader.skipPadding();
        int low = reader.readUint32();
        int high = reader.readUint32();
        int[] jmpOffsets = reader.readUint32s(high - low + 1);
    }

    @Override
    public void execute(Frame frame) {

    }
}
