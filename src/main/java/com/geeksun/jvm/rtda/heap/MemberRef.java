package com.geeksun.jvm.rtda.heap;

import com.geeksun.jvm.classfile.ConstantPool.ConstantMemberRefInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRef {
    private SymRef symRef;
    private String name;
    private String descriptor;

    MemberRef(ConstantMemberRefInfo refInfo){
        symRef = new SymRef();
        symRef.setClassName(refInfo.getClassName());
        String nameAndDescriptor = refInfo.getNameAndDescriptor();
        name = nameAndDescriptor.split(" ")[0];
        descriptor = nameAndDescriptor.split(" ")[1];
    }

}
