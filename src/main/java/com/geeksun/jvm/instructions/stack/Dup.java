package com.geeksun.jvm.instructions.stack;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;
import com.geeksun.jvm.rtda.Slot;

public class Dup extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x59;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        Slot slot = stack.popSlot();
        stack.pushSlot(new Slot(slot.getNum(), slot.getRef()));
        stack.pushSlot(new Slot(slot.getNum(), slot.getRef()));
    }
}
