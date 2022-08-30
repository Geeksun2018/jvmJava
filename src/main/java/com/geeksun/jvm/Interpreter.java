package com.geeksun.jvm;

import com.geeksun.jvm.classfile.Attributes.CodeAttribute;
import com.geeksun.jvm.classfile.ConstantPool.MemberInfo;
import com.geeksun.jvm.instructions.base.BytecodeReader;
import com.geeksun.jvm.instructions.base.Instruction;
import com.geeksun.jvm.instructions.base.InstructionFactory;
import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.Thread;
import com.geeksun.jvm.rtda.heap.Method;

import java.nio.file.Paths;

public class Interpreter {

    public void interpret(Method method, boolean logInst){
        Thread thread = new Thread();
        Frame frame = new Frame(thread,  method);
        thread.pushFrame(frame);
//        logFrames(thread);
        loop(thread, logInst);
    }

    public void loop(Thread thread, boolean logInst){
        BytecodeReader reader = new BytecodeReader();
        int opCode;
        do {
            Frame frame = thread.currentFrame();
            int pc = frame.getNextPc();
            thread.setPc(pc);

            reader.reset(frame.getMethod().getCode(), pc);
            opCode = reader.readUInt8();
            Instruction instruction = InstructionFactory.getByOpCode(opCode);
            instruction.fetchOperands(reader);
            frame.setNextPc(reader.getPc());

//            if (logInst) {
            logInstruction(frame, instruction);
//            }
            instruction.execute(frame);
        } while (!thread.getStack().isEmpty());
    }

    public void logInstruction(Frame frame, Instruction instruction){
        Method method = frame.getMethod();
        String className = method.getClassMember().get_class().getName();
        String methodName = method.getClassMember().getName();
        int pc = frame.getThread().getPc();
        System.out.printf("%s.%s() #%2d %s %s\n",className,methodName,pc,instruction.getReName(),instruction);
    }

//    public void logFrames(Thread thread){
//        while(!thread.getStack().isEmpty()){
//            Frame frame = thread.popFrame();
//            Method method = frame.getMethod();
//            String className = method.getClassMember().getName();
//            System.out.printf(">> pc:%4d %s.%s%s \n", frame.getNextPc(), className,
//                    method.getClassMember().getName(), method.getClassMember().getDescriptor());
//        }
//    }

}
