package com.geeksun.jvm.rtda.heap;

import com.geeksun.jvm.classfile.ConstantPool.ConstantInterfaceMethodRefInfo;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.Paths;

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
        Class d = this.memberRef.getSymRef().getCp().get_class();
        Class c = this.memberRef.getSymRef().resolveClass();
        if(!c.isInterface()){
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        method = lookupInterfaceMethod(c, this.memberRef.getName(), this.memberRef.getDescriptor());
        if(method == null){
            System.out.println("java.lang.NoSuchMethodError");
        }
        if(!method.getClassMember().isAccessibleTo(c)){
            System.out.println("java.lang.IllegalAccessError");
        }
    }

    public Method lookupInterfaceMethod(Class iface, String name, String descriptor){
        for(Method method1:iface.getMethods()){
            if(method1.getClassMember().getName().equals(name)&&method.getClassMember().getDescriptor().equals(descriptor)){
                return method1;
            }
        }
        return MethodLookup.lookupMethodInInterfaces(iface.getInterfaces(), name, descriptor);
    }


}
