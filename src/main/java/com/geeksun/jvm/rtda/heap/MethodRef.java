package com.geeksun.jvm.rtda.heap;

import com.geeksun.jvm.classfile.ConstantPool.ConstantMethodRefInfo;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.Paths;

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
        Class d = this.memberRef.getSymRef().getCp().get_class();
        Class c = this.memberRef.getSymRef().resolveClass();
        if(c.isInterface()){
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        method = lookupMethod(c, this.getMemberRef().getName(), this.getMemberRef().getDescriptor());
        return;
    }

    private Method lookupMethod(Class c, String name, String descriptor) {
        method = MethodLookup.lookupMethodInClass(c, name, descriptor);
        if(method == null){
            method = MethodLookup.lookupMethodInInterfaces(c.getInterfaces(), name, descriptor);
        }
        return method;
    }


}
