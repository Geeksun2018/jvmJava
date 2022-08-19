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
        if(this._class == null){
            resolveClassRef();
        }
        return this._class;
    }

    public void resolveClassRef(){
        Class d = this.cp.get_class();
        Class c = d.getClassLoader().loadClass(this.className);
        if(!c.isAccessibleTo(d)){
            System.out.println("java.lang.IllegalAccessError");
        }
        this._class = c;
    }


}
