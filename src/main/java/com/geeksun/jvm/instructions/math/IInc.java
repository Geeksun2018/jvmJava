package com.geeksun.jvm.instructions.math;

import com.geeksun.jvm.instructions.base.BytecodeReader;
import com.geeksun.jvm.instructions.base.Index8Instruction;
import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.LocalVars;

public class IInc extends Index8Instruction {

    private int constantVal;

    @Override
    public int getOpCode() {
        return 0x84;
    }

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.index = reader.readUint8();
        this.constantVal = reader.readUint8();
    }

    @Override
    public void execute(Frame frame) {
        LocalVars localVars = frame.getLocalVars();
        int val = localVars.getInt(index);
        val += constantVal;
        localVars.setInt(index, val);
    }
}
