package com.geeksun.jvm.instructions.base;

import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.Thread;
import com.geeksun.jvm.rtda.heap.Method;

public class MethodInvokeLogic {

    public void invokeMethod(Frame invokeFrame, Method method){
        Thread thread = invokeFrame.getThread();
        Frame newFrame = new Frame(thread, method);
        thread.pushFrame(newFrame);

//        method

    }


}
