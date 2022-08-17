package com.geeksun.jvm.instructions.references;

import com.geeksun.jvm.instructions.base.Index16Instruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;
import com.geeksun.jvm.rtda.heap.Class;
import com.geeksun.jvm.rtda.heap.ClassRef;
import com.geeksun.jvm.rtda.heap.ConstantPool;
import com.geeksun.jvm.rtda.heap.Object;

public class InstanceOf extends Index16Instruction {
    @Override
    public int getOpCode() {
        return 0xc1;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        Object ref = stack.popRef();
        if(ref == null){
            stack.pushInt(0);
            return;
        }
        ConstantPool cp = frame.getMethod().getClassMember().get_class().getConstantPool();
        ClassRef classRef = (ClassRef) cp.getConstant(index);
        Class c = classRef.getSymRef().resolveClass();
        if(ref.isInstanceOf(c)){
            stack.pushInt(1);
        }else{
            stack.pushInt(0);
        }
    }
}
