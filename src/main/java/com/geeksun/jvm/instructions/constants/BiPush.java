package com.geeksun.jvm.instructions.constants;

import com.geeksun.jvm.instructions.base.BytecodeReader;
import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;

public class BiPush extends NoOperandsInstruction {
    private int val;

    @Override
    public int getOpCode() {
        return 0x10;
    }

    @Override
    public void fetchOperands(BytecodeReader reader) {
        val = reader.readInt8();
    }

    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushInt(this.val);
    }
}
