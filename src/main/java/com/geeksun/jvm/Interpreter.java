package com.geeksun.jvm;

import com.geeksun.jvm.classfile.Attributes.CodeAttribute;
import com.geeksun.jvm.classfile.ConstantPool.MemberInfo;
import com.geeksun.jvm.instructions.base.BytecodeReader;
import com.geeksun.jvm.instructions.base.Instruction;
import com.geeksun.jvm.instructions.base.InstructionFactory;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.Thread;
import com.geeksun.jvm.rtda.heap.Method;

public class Interpreter {

    public void interpret(Method method){
        Thread thread = new Thread();
        Frame frame = new Frame(thread,  method);
        thread.pushFrame(frame);
        loop(thread, method.getCode());
    }

    public void loop(Thread thread, byte[] byteCode){
        Frame frame = thread.popFrame();
        BytecodeReader reader = new BytecodeReader(byteCode, frame.getNextPc());
        int opCode;
        do{
            int pc = frame.getNextPc();
            thread.setPc(pc);
            System.out.print("pc:" + pc);
            reader.reset(byteCode, pc);
            opCode = reader.readInt8();
            System.out.print("        opCode: " + opCode);
            Instruction instruction = InstructionFactory.getByOpCode(opCode);
            instruction.fetchOperands(reader);
            frame.setNextPc(reader.getPc());
            instruction.execute(frame);
            System.out.print("        op: " + instruction.getReName());
            System.out.println("        localVars: " + frame.getLocalVars());
        }while (opCode != 0xb1);
    }

}
