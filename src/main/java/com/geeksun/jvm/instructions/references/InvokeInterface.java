package com.geeksun.jvm.instructions.references;

import com.geeksun.jvm.instructions.base.BaseMethod;
import com.geeksun.jvm.instructions.base.BytecodeReader;
import com.geeksun.jvm.instructions.base.Index16Instruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.heap.*;
import com.geeksun.jvm.rtda.heap.Object;

public class InvokeInterface extends Index16Instruction {
    @Override
    public int getOpCode() {
        return 0xb9;
    }

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.index = reader.readInt16();
        reader.readInt8();
        reader.readInt8();
    }

    @Override
    public void execute(Frame frame) {
        ConstantPool cp = frame.getMethod().getClassMember().get_class().getConstantPool();
        InterfaceMethodRef methodRef = (InterfaceMethodRef) cp.getConstant(index);
        Method resolvedMethod = methodRef.resolveInterfaceMethod();
        if(resolvedMethod.getClassMember().isStatic()||resolvedMethod.getClassMember().isPrivate()){
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        Object ref = frame.getOperandStack().getRefFromTop(resolvedMethod.getArgSlotCount() - 1);
        if(ref == null){
            System.out.println("java.lang.NullPointerException");
        }
        assert ref != null;
        if(!ref.get_class().isImplements(methodRef.getMemberRef().getSymRef().resolveClass())){
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        Method methodToBeInvoked = MethodLookup.lookupMethodInClass(ref.get_class(),methodRef.getMemberRef().getName(),
                methodRef.getMemberRef().getDescriptor());
        if(methodToBeInvoked == null||methodToBeInvoked.getClassMember().isAbstract()){
            System.out.println("java.lang.AbstractMethodError");
        }
        assert methodToBeInvoked != null;
        if(!methodToBeInvoked.getClassMember().isPublic()){
            System.out.println("java.lang.IllegalAccessError");
        }
        BaseMethod.invokeMethod(frame, methodToBeInvoked);
    }
}
