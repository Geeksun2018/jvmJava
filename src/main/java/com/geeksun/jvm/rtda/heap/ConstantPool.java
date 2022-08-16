package com.geeksun.jvm.rtda.heap;

import com.geeksun.jvm.classfile.ConstantPool.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstantPool {
    private Class _class;
    java.lang.Object[] constants;

    public ConstantPool(Class _class, ConstantInfo[] constantInfos){
        int cpCount = constantInfos.length;
        this.constants = new java.lang.Object[cpCount];
        this._class = _class;
        for(int i = 0;i < cpCount;i++){
            if(constantInfos[i] instanceof ConstantIntegerInfo){
                constants[i] = ((ConstantIntegerInfo) constantInfos[i]).getVal();
            } else if (constantInfos[i] instanceof ConstantFloatInfo) {
                constants[i] = ((ConstantFloatInfo) constantInfos[i]).getVal();
            }else if(constantInfos[i] instanceof ConstantLongInfo){
                constants[i] = ((ConstantLongInfo) constantInfos[i]).getVal();
            }else if(constantInfos[i] instanceof ConstantDoubleInfo){
                constants[i] = ((ConstantDoubleInfo) constantInfos[i]).getVal();
            }else if(constantInfos[i] instanceof ConstantStringInfo){
                constants[i] = ((ConstantStringInfo) constantInfos[i]).getString();
            }else if(constantInfos[i] instanceof ConstantClassInfo){
//                constants[i] = constantInfos[i].
            }
        }
    }

}