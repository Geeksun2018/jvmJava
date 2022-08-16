package com.geeksun.jvm.rtda.heap;

import com.geeksun.jvm.classfile.ConstantPool.ConstantFieldRefInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldRef {
    private MemberRef memberRef;
    private Field field;

    FieldRef(ConstantPool constantPool, ConstantFieldRefInfo refInfo){
        memberRef = new MemberRef(refInfo);
        memberRef.getSymRef().setCp(constantPool);
    }


    public void resolveFieldRef(){

    }


}
