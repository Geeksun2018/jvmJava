package com.geeksun.jvm.instructions.references;

import com.geeksun.jvm.instructions.base.Index16Instruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.heap.Class;
import com.geeksun.jvm.rtda.heap.ClassRef;
import com.geeksun.jvm.rtda.heap.ConstantPool;
import com.geeksun.jvm.rtda.heap.Object;

public class New extends Index16Instruction {
    @Override
    public int getOpCode() {
        return 0xbb;
    }

    @Override
    public void execute(Frame frame) {
        ConstantPool constantPool = frame.getMethod().getClassMember().get_class().getConstantPool();
        ClassRef classRef = (ClassRef) constantPool.getConstant(this.index);
        Class _class = classRef.getSymRef().resolveClass();
//      todo: init class
        if(_class.isInterface()||_class.isAbstract()){
            System.out.println("java.lang.InstantiationError");
        }
        Object ref = new Object(_class);
        frame.getOperandStack().pushRef(ref);
    }
}
