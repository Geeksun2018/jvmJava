package com.geeksun.jvm.instructions.references;

import com.geeksun.jvm.classfile.ConstantPool.ConstantPool;
import com.geeksun.jvm.instructions.base.Index16Instruction;
import com.geeksun.jvm.rtda.Frame;

public class GetStatic extends Index16Instruction {
    @Override
    public int getOpCode() {
        return 0xb2;
    }

    @Override
    public void execute(Frame frame) {
//        ConstantPool constantPool = frame.ge
    }
}
