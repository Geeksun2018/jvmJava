package com.geeksun.jvm.instructions.references;

import com.geeksun.jvm.instructions.base.Index16Instruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.OperandStack;
import com.geeksun.jvm.rtda.heap.ConstantPool;
import com.geeksun.jvm.rtda.heap.MethodRef;

public class InvokeVirtual extends Index16Instruction {
    @Override
    public int getOpCode() {
        return 0xb6;
    }

    @Override
    public void execute(Frame frame) {
        ConstantPool constantPool = frame.getMethod().getClassMember().get_class().getConstantPool();
        MethodRef methodRef = (MethodRef) constantPool.getConstant(index);
        if(methodRef.getMemberRef().getName().equals("println")){
            OperandStack stack = frame.getOperandStack();
            switch (methodRef.getMemberRef().getDescriptor()){
                case "Z(V)":
                    System.out.println(stack.popInt() != 0);
                    break;
                case "(C)V":
                case "(B)V":
                case "(S)V":
                case "(I)V":
                    System.out.print("   res:   " +  stack.popInt());
                    break;
                case "(J)V":
                    System.out.println(stack.popLong());
                    break;
                case "(F)V":
                    System.out.println(stack.popFloat());
                    break;
                case "(D)V":
                    System.out.println(stack.popDouble());
                    break;
                default:
                    System.out.println("println: " + methodRef.getMemberRef().getDescriptor());
            }
        }
    }
}
