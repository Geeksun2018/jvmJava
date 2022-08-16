package com.geeksun.jvm.rtda.heap;

import com.geeksun.jvm.classfile.ConstantPool.ConstantInterfaceMethodRefInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterfaceMethodRef {
    private MemberRef memberRef;
    private Method method;

    InterfaceMethodRef(ConstantPool cp, ConstantInterfaceMethodRefInfo refInfo){
        memberRef = new MemberRef(refInfo);
        memberRef.getSymRef().setCp(cp);
    }

    public Method resolveInterfaceMethod(){
        if(this.method == null){
            this.resolveInterfaceMethodRef();
        }
        return this.method;
    }

    private void resolveInterfaceMethodRef() {
        return;
    }


}
