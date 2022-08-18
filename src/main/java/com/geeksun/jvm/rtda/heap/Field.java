package com.geeksun.jvm.rtda.heap;

import com.geeksun.jvm.classfile.Attributes.ConstantValueAttribute;
import com.geeksun.jvm.classfile.ConstantPool.MemberInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Field {
    private ClassMember classMember;
    private int constValueIndex;
    private int slotId;

    Field(Class aClass, MemberInfo memberInfo){
        classMember = new ClassMember(memberInfo, aClass);
        ConstantValueAttribute attribute = memberInfo.getConstantValueAttribute();
        if(attribute != null){
            this.constValueIndex = attribute.getConstantValueIndex();
        }
    }

    public static Field[] getFields(Class _class, MemberInfo[] cfFields){
        Field[] fields = new Field[cfFields.length];
        for(int i = 0;i < cfFields.length;i++){
            fields[i].setClassMember(new ClassMember(cfFields[i], _class));
        }
        return fields;
    }

    public boolean isVolatile(){
        return (this.classMember.getAccessFlags()&AccessFlags.ACC_VOLATILE) != 0;
    }

    public boolean isTransient(){
        return (this.classMember.getAccessFlags()&AccessFlags.ACC_TRANSIENT) != 0;
    }

    public boolean isEnum(){
        return (this.classMember.getAccessFlags()&AccessFlags.ACC_ENUM) != 0;
    }

    public boolean isLongOrDouble(){
        return this.classMember.getDescriptor().equals("J") || this.classMember.getDescriptor().equals("D");
    }

}
