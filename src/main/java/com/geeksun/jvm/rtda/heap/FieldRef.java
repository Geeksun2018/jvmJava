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

    public Field resolveField(){
        if(this.field == null){
            resolveFieldRef();
        }
        return this.field;
    }

    public void resolveFieldRef(){
        Class d = this.memberRef.getSymRef().getCp().get_class();
        Class c = this.memberRef.getSymRef().resolveClass();
        Field f = lookupField(c, memberRef.getName(), memberRef.getDescriptor());
        if(f == null){
            System.out.println("java.lang.NoSuchFieldError");
        }
        assert f != null;
        if(!f.getClassMember().isAccessibleTo(d)){
            System.out.println("java.lang.IllegalAccessError");
        }
        this.field = f;
    }
    public Field lookupField(Class c, String name, String descriptor){
        for(Field field1:c.getFields()){
            if(field1.getClassMember().getName().equals((name))&&field1.getClassMember().getDescriptor().equals(descriptor)){
                return field1;
            }
        }
        for(Class face:c.getInterfaces()){
            return lookupField(face, name, descriptor);
        }
        if(c.getSuperClass()!=null){
            return lookupField(c.getSuperClass(), name, descriptor);
        }
        return null;
    }

}
