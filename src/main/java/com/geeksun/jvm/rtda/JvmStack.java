package com.geeksun.jvm.rtda;

import java.util.LinkedList;

public class JvmStack extends LinkedList<Frame> {
    private int maxSize;

    public JvmStack(int maxSize){
        super();
        this.maxSize = maxSize;
    }

    public void pushFrame(Frame frame){
        if(this.size() >= this.maxSize){
            System.out.println("java.lang.StackOverflowError");
        }
        this.push(frame);
    }

    public Frame popFrame(){
        if(isEmpty()){
            System.out.println("jvm stack is empty!");
            return null;
        }
        return this.pop();
    }

    public Frame topFrame(){
        return this.peek();
    }


}
