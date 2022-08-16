package com.geeksun.jvm.rtda.heap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SymRef {
    private ConstantPool cp;
    private String className;
    private Class _class;

    public SymRef(ConstantPool constantPool, String className){
        this.cp = constantPool;
        this.className = className;
    }

    public SymRef(){

    }

    public Class resolveClass(){
        return null;
    }

    public void resolveClassRef(){

    }


}
