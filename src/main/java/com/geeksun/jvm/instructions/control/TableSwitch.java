package com.geeksun.jvm.instructions.control;

import com.geeksun.jvm.instructions.base.BranchInstruction;
import com.geeksun.jvm.instructions.base.BytecodeReader;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;
import com.geeksun.jvm.rtda.Thread;

public class TableSwitch extends BranchInstruction {

    private int defaultOffset;
    private int low;
    private int high;
    private int[] jumpOffsets;

    @Override
    public int getOpCode() {
        return 0xaa;
    }

    @Override
    public void fetchOperands(BytecodeReader reader) {
        reader.skipPadding();
        low = reader.readInt32();
        high = reader.readInt32();
        jumpOffsets = reader.readInt32s(high - low + 1);
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        int index = stack.popInt();
        if(index >= low && index <= high){
            offset = jumpOffsets[index - low];
        }else{
            offset = defaultOffset;
        }
        Thread thread = frame.getThread();
        thread.setPc(offset);
    }
}
