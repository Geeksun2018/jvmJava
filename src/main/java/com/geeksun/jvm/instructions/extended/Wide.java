package com.geeksun.jvm.instructions.extended;

import com.geeksun.jvm.instructions.base.BranchInstruction;
import com.geeksun.jvm.instructions.base.BytecodeReader;
import com.geeksun.jvm.instructions.base.Instruction;
import com.geeksun.jvm.rtda.Frame;

public class Wide extends BranchInstruction {

    private Instruction modifiedInstruction;

    @Override
    public int getOpCode() {
        return 0xc4;
    }

    @Override
    public void fetchOperands(BytecodeReader reader) {
        int opCode = reader.readUint8();
//        switch (opCode){
//            case 0x15:
//
//
//        }
    }

    @Override
    public void execute(Frame frame) {
        modifiedInstruction.execute(frame);
    }
}
