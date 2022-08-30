package com.geeksun.jvm.instructions.references;

import com.geeksun.jvm.instructions.base.BaseMethod;
import com.geeksun.jvm.instructions.base.Index16Instruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.heap.Class;
import com.geeksun.jvm.rtda.heap.ConstantPool;
import com.geeksun.jvm.rtda.heap.Method;
import com.geeksun.jvm.rtda.heap.MethodRef;

public class InvokeStatic extends Index16Instruction {
    @Override
    public int getOpCode() {
        return 0xb8;
    }

    @Override
    public void execute(Frame frame) {
        ConstantPool cp = frame.getMethod().getClassMember().get_class().getConstantPool();
        MethodRef methodRef = (MethodRef) cp.getConstant(this.index);
        Method resolvedMethod = methodRef.resolveMethod();
        if(!resolvedMethod.getClassMember().isStatic()){
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        Class _class = resolvedMethod.getClassMember().get_class();
        if(!_class.isInitStarted()){
            frame.revertNextPc();
            BaseMethod.initClass(frame.getThread(), _class);
            return;
        }
        BaseMethod.invokeMethod(frame, resolvedMethod);
    }
}
