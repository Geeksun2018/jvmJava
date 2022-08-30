package com.geeksun.jvm.instructions.base;

import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.Slot;
import com.geeksun.jvm.rtda.Thread;
import com.geeksun.jvm.rtda.heap.Class;
import com.geeksun.jvm.rtda.heap.Method;

import java.util.Objects;

public class BaseMethod {

    public static void invokeMethod(Frame invokeFrame, Method method){
        Thread thread = invokeFrame.getThread();
        Frame newFrame = new Frame(thread, method);
        thread.pushFrame(newFrame);

        int argSlotCount = method.getArgSlotCount();
        if(argSlotCount > 0){
            for(int i = argSlotCount - 1;i >= 0;i--){
                Slot slot = invokeFrame.getOperandStack().popSlot();
                newFrame.getLocalVars().setSlot(i, slot);
            }
        }
        if(method.getClassMember().isNative()){
            if(Objects.equals(method.getClassMember().getName(), "registerNatives")){
                thread.popFrame();
            }else{
                System.out.printf("native method: %s.%s%s",method.getClassMember().get_class().getName(), method.getClassMember().getName(), method.getClassMember().getDescriptor());
            }
        }


    }

    public static void initClass(Thread thread, Class _class){
        _class.startInit();
        scheduleClinit(thread, _class);
        initSuperClass(thread, _class);
    }

    private static void initSuperClass(Thread thread, Class aClass) {
        if(!aClass.isInterface()){
            Class superClass = aClass.getSuperClass();
            if(superClass != null&&!superClass.isInitStarted()){
                initClass(thread, superClass);
            }
        }
    }

    private static void scheduleClinit(Thread thread, Class aClass) {
        Method clinit = aClass.getClInitMethod();
        if(clinit != null){
            Frame newFrame = new Frame(thread, clinit);
            thread.pushFrame(newFrame);
        }
    }

}
