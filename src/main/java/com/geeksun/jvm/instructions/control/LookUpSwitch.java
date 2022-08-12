package com.geeksun.jvm.instructions.control;

import com.geeksun.jvm.instructions.base.BranchInstruction;
import com.geeksun.jvm.instructions.base.BytecodeReader;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;
import com.geeksun.jvm.rtda.Thread;

public class LookUpSwitch extends BranchInstruction {

    private int defaultOffset;
    private int nPairs;
    private int[] matchOffsets;

    @Override
    public int getOpCode() {
        return 0xab;
    }

    @Override
    public void fetchOperands(BytecodeReader reader) {
        reader.skipPadding();
        defaultOffset = reader.readUint32();
        nPairs = reader.readUint32();
        matchOffsets = reader.readUint32s(nPairs * 2);
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        Thread thread = frame.getThread();
        int key = stack.popInt();
        for(int i = 0;i < nPairs * 2;i+=2){
            if(matchOffsets[i] == key){
                offset = matchOffsets[i + 1];
                thread.setPc(offset);
                return;
            }
        }
        thread.setPc(defaultOffset);
    }
}
