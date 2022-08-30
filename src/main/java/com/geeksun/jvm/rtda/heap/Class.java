package com.geeksun.jvm.rtda.heap;

import com.geeksun.jvm.classfile.ClassFile;
import com.geeksun.jvm.classfile.ConstantPool.MemberInfo;
import com.geeksun.jvm.rtda.LocalVars;
import com.geeksun.jvm.rtda.Slot;
import com.sun.org.apache.bcel.internal.generic.PUSH;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.Paths;

@Getter
@Setter
public class Class {
    private int accessFlags;
    private String name;
    private String superClassName;
    private String[] interfaceNames;
    private ConstantPool constantPool;
    private Field[] fields;
    private Method[] methods;
    private ClassLoader classLoader;
    private Class superClass;
    private Class[] interfaces;
    private int instanceSlotCount;
    private int staticSlotCount;
    private LocalVars staticVars;
    boolean initStarted;

    Class(ClassFile classFile){
        this.accessFlags = classFile.getAccessFlags();
        this.name = classFile.getClassName();
        this.superClassName = classFile.getSuperClassName();
        this.interfaceNames = classFile.getInterfaceNames();
        this.constantPool = new ConstantPool(this, classFile.getConstantPool().getConstantInfos());
        MemberInfo[] fieldInfos = classFile.getFields();
        this.fields = new Field[fieldInfos.length];
        MemberInfo[] methodInfos = classFile.getMethods();
        this.methods = new Method[methodInfos.length];
        for(int i = 0;i < fieldInfos.length;i++){
            this.fields[i] = new Field(this, fieldInfos[i]);
        }
        for(int i = 0;i < methodInfos.length;i++){
            this.methods[i] = new Method(this, methodInfos[i]);
        }
    }

    public boolean isPublic(){
        return (this.accessFlags&AccessFlags.ACC_PUBLIC) != 0;
    }

    public boolean isFinal(){
        return (this.accessFlags&AccessFlags.ACC_FINAL) != 0;
    }

    public boolean isSuper(){
        return (this.accessFlags&AccessFlags.ACC_SUPER) != 0;
    }

    public boolean isInterface(){
        return (this.accessFlags&AccessFlags.ACC_INTERFACE) != 0;
    }

    public boolean isAbstract(){
        return (this.accessFlags&AccessFlags.ACC_ABSTRACT) != 0;
    }

    public boolean isSynthetic(){
        return (this.accessFlags&AccessFlags.ACC_SYNTHETIC) != 0;
    }

    public boolean isAnnotation(){
        return (this.accessFlags&AccessFlags.ACC_ANNOTATION) != 0;
    }

    public boolean isEnum(){
        return (this.accessFlags&AccessFlags.ACC_ENUM) != 0;
    }

    public ConstantPool getConstantPool(){
        return this.constantPool;
    }

    public String getPackageName(){
        return this.name.substring(0, this.name.lastIndexOf("/"));
    }

    public boolean isAccessibleTo(Class other){
        return this.isPublic() || this.getPackageName().equals(other.getPackageName());
    }

    public Method getStaticMethod(String name, String descriptor){
        for(Method method:this.methods){
            if(method.getClassMember().isStatic()&&method.getClassMember().getName().equals(name)
            &&method.getClassMember().getDescriptor().equals(descriptor)){
                return method;
            }
        }
        return null;
    }

    public Method getMainMethod(){
        return this.getStaticMethod("main", "([Ljava/lang/String;)V");
    }

    public Method getClInitMethod(){
        return this.getStaticMethod("<clinit>","()V");
    }

    public Object getObject(){
        return new Object(this);
    }

    public boolean isAssignableFrom(Class aClass) {
        return true;
    }

    public boolean isSubClassOf(Class other){
        for(Class c = this.superClass;c != null;c = c.superClass){
            if(c == other){
                return true;
            }
        }
        return false;
    }

    public boolean isImplements(Class _interface){
        for(Class c = this;c != null;c = c.superClass){
            for(Class interfaceItem:c.interfaces){
                if(interfaceItem == _interface||interfaceItem.isSubInterfaceOf(_interface)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSubInterfaceOf(Class _interface){
        for(Class interfaceItem:this.interfaces){
            if(interfaceItem == _interface || interfaceItem.isSubInterfaceOf(_interface)){
                return true;
            }
        }
        return false;
    }

    public void startInit() {
        this.initStarted = true;
    }

    public boolean isSuperClassOf(Class other) {
        return other.isSubClassOf(this);
    }
}
