package com.geeksun.jvm.rtda.heap;

import com.geeksun.jvm.classfile.ConstantPool.ConstantClassInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassRef {
    private SymRef symRef;

    ClassRef(ConstantPool constantPool, ConstantClassInfo constantClassInfo){
        this.symRef = new SymRef(constantPool, constantClassInfo.getName());
    }

}
