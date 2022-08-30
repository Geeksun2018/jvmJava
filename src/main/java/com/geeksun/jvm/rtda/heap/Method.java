package com.geeksun.jvm.rtda.heap;

import com.geeksun.jvm.classfile.Attributes.CodeAttribute;
import com.geeksun.jvm.classfile.ConstantPool.MemberInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Method {
    private ClassMember classMember;
    private int maxStack;
    private int maxLocals;
    private byte[] code;

    private int argSlotCount;

    Method(Class _class, MemberInfo memberInfo){
        classMember = new ClassMember(memberInfo, _class);
        CodeAttribute codeAttribute = memberInfo.getCodeAttribute();
        if(codeAttribute != null){
            this.maxLocals = codeAttribute.getMaxLocals();
            this.code = codeAttribute.getCode();
            this.maxStack = codeAttribute.getMaxStack();
        }
        this.calcArgSlotCount();
    }

    private void calcArgSlotCount(){
        MethodDescriptorParser methodDescriptorParser = new MethodDescriptorParser(this.classMember.getDescriptor());
        for(String parameterType:methodDescriptorParser.getParsed().getParameterTypes()){
            this.argSlotCount++;
            if(Objects.equals(parameterType, "J")||Objects.equals(parameterType, "D")){
                this.argSlotCount++;
            }
        }
        if(!this.classMember.isStatic()){
            this.argSlotCount++;
        }
    }

    public static Method[] getMethods(Class _class, MemberInfo[] cfMethods){
        Method[] methods = new Method[cfMethods.length];
        for(int i = 0;i < methods.length;i++){
            methods[i] = new Method(_class, cfMethods[i]);
        }
        return methods;
    }

}
