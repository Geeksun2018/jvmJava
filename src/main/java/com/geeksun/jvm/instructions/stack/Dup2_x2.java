package com.geeksun.jvm.instructions.stack;

import com.geeksun.jvm.instructions.base.NoOperandsInstruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;
import com.geeksun.jvm.rtda.Slot;

public class Dup2_x2 extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x5e;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        Slot slot1 = stack.popSlot();
        Slot slot2 = stack.popSlot();
        Slot slot3 = stack.popSlot();
        Slot slot4 = stack.popSlot();

        stack.pushSlot(slot2);
        stack.pushSlot(slot1);
        stack.pushSlot(slot4);
        stack.pushSlot(slot3);
        stack.pushSlot(new Slot(slot2.getNum(), slot2.getRef()));
        stack.pushSlot(new Slot(slot1.getNum(), slot1.getRef()));
    }
}
