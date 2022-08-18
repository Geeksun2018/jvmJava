package com.geeksun.jvm.rtda.heap;

import com.geeksun.jvm.classfile.ConstantPool.ConstantMethodRefInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MethodRef {
    private MemberRef memberRef;
    private Method method;

    MethodRef(ConstantPool cp, ConstantMethodRefInfo refInfo){
        memberRef = new MemberRef(refInfo);
        memberRef.getSymRef().setCp(cp);
    }

    public Method resolveMethod(){
        if(this.method == null){
            this.resolveMethodRef();
        }
        return this.method;
    }

    private void resolveMethodRef() {
        return;
    }


}
