package com.geeksun.jvm.instructions.references;

import com.geeksun.jvm.instructions.base.Index16Instruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;
import com.geeksun.jvm.rtda.heap.Class;
import com.geeksun.jvm.rtda.heap.ClassRef;
import com.geeksun.jvm.rtda.heap.ConstantPool;
import com.geeksun.jvm.rtda.heap.Object;

public class CheckCast extends Index16Instruction {
    @Override
    public int getOpCode() {
        return 0xc0;
    }

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        Object ref = stack.popRef();
        stack.pushRef(ref);
        if(ref == null){
            return;
        }
        ConstantPool cp = frame.getMethod().getClassMember().get_class().getConstantPool();
        ClassRef classRef = (ClassRef) cp.getConstant(index);
        Class aClass = classRef.getSymRef().resolveClass();
        if(!ref.isInstanceOf(aClass)){
            System.out.println("java.lang.ClassCastException");
        }
    }
}
