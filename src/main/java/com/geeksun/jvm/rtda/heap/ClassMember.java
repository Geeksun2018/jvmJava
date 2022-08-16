package com.geeksun.jvm.rtda.heap;

import com.geeksun.jvm.classfile.ClassFile;
import com.geeksun.jvm.classfile.ConstantPool.MemberInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassMember {
    private int accessFlags;
    private String name;
    private String descriptor;
    private Class _class;

    ClassMember(MemberInfo memberInfo, Class _class){
        this.accessFlags = memberInfo.getAccessFlags();
        this.name = memberInfo.getName();
        this.descriptor = memberInfo.getDescriptor();
        this._class = _class;
    }

    public boolean isPublic(){
        return (this.accessFlags&AccessFlags.ACC_PUBLIC) != 0;
    }

    public boolean isPrivate(){
        return (this.accessFlags&AccessFlags.ACC_PRIVATE) != 0;
    }

    public boolean isProtected(){
        return (this.accessFlags&AccessFlags.ACC_PROTECTED) != 0;
    }

    public boolean isStatic(){
        return (this.accessFlags&AccessFlags.ACC_STATIC) != 0;
    }

    public boolean isFinal(){
        return (this.accessFlags&AccessFlags.ACC_FINAL) != 0;
    }

    public boolean isSynthetic(){
        return (this.accessFlags&AccessFlags.ACC_SYNTHETIC) != 0;
    }


}
