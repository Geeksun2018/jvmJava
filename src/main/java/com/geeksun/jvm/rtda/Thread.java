package com.geeksun.jvm.rtda;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Thread {
    private int pc;
    private JvmStack stack;

    public Thread(){
        stack = new JvmStack(1024);
    }

    public void pushFrame(Frame frame){
        this.stack.pushFrame(frame);
    }

    public Frame popFrame(){
        return this.stack.popFrame();
    }

    public Frame currentFrame(){
        return this.stack.topFrame();
    }

}
