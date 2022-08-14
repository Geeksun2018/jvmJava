package com.geeksun.jvm;

import com.geeksun.jvm.classfile.Attributes.CodeAttribute;
import com.geeksun.jvm.classfile.ConstantPool.MemberInfo;
import com.geeksun.jvm.instructions.base.BytecodeReader;
import com.geeksun.jvm.instructions.base.Instruction;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.Thread;

public class Interpreter {

    public void interpret(MemberInfo memberInfo){
        CodeAttribute codeAttribute = memberInfo.getCodeAttribute();
        int maxLocals = codeAttribute.getMaxLocals();
        int maxStack = codeAttribute.getMaxStack();
        byte[] byteCode = codeAttribute.getCode();
        Thread thread = new Thread();
        Frame frame = new Frame(thread, maxLocals, maxStack);
        thread.pushFrame(frame);
    }

    public void loop(Thread thread, byte[] byteCode){
        Frame frame = thread.popFrame();
        BytecodeReader reader = new BytecodeReader(byteCode, frame.getNextPc());
        int opCode;
//        do{
//            int pc = frame.getNextPc();
//            thread.setPc(pc);
//            System.out.println("pc:" + reader.getPc());
//            reader.reset(byteCode, pc);
//            opCode = reader.readUint8();
//            System.out.println("opCode: " + opCode);
////            Instruction instruction =
//        }
        return;
    }

}
