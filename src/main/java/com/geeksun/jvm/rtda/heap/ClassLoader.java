package com.geeksun.jvm.rtda.heap;

import com.geeksun.jvm.classfile.ClassFile;
import com.geeksun.jvm.classpath.Classpath;
import com.geeksun.jvm.rtda.LocalVars;
import com.geeksun.jvm.rtda.Slot;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ClassLoader {
    private Classpath classpath;
    private Map<String, Class> classMap;

    ClassLoader(Classpath classpath){
        this.classpath = classpath;
        classMap = new HashMap<>();
    }

    public Class loadClass(String name){
        if(classMap.containsKey(name)){
            return classMap.get(name);
        }
        return this.loadNonArrayClass(name);
    }

    private Class loadNonArrayClass(String name) {
        byte[] data = classpath.readClass(name);
        Class _class = defineClass(data);
        link(_class);
        return null;
    }

    private void link(Class aClass) {
        verify(aClass);
        prepare(aClass);
    }

    private void prepare(Class aClass) {
        calcInstanceFieldSlotIds(aClass);
        calcStaticFieldSlotIds(aClass);
        allocAndInitStaticVars(aClass);

    }

    private void allocAndInitStaticVars(Class aClass) {
        aClass.setStaticVars(new LocalVars(aClass.getStaticSlotCount()));
        for(Field field:aClass.getFields()){
            if(field.getClassMember().isStatic()&&field.getClassMember().isFinal()){
                initStaticFinalVar(aClass, field);
            }
        }
    }

    private void initStaticFinalVar(Class aClass, Field field) {
       LocalVars vars = aClass.getStaticVars();
        ConstantPool constantPool = aClass.getConstantPool();
        int cpIndex = field.getConstValueIndex();
        int slotId = field.getSlotId();

        if(cpIndex > 0){
            switch (field.getClassMember().getDescriptor()){
                case "Z":
                case "B":
                case "C":
                case "S":
                case "I":
                    vars.setInt(slotId, (Integer) constantPool.getConstant(cpIndex));
                    break;
                case "J":
                    vars.setLong(slotId, (Long) constantPool.getConstant(cpIndex));
                    break;
                case "F":
                    vars.setFloat(slotId, (Float) constantPool.getConstant(cpIndex));
                    break;
                case "D":
                    vars.setDouble(slotId, (Double) constantPool.getConstant(cpIndex));
                    break;
                case "Ljava/lang/String;":
                    System.out.println("todo");
                    break;
            }
        }

    }

    private void calcStaticFieldSlotIds(Class aClass) {
        int slotId = 0;
        for(Field field:aClass.getFields()){
            if(field.getClassMember().isStatic()){
                field.setSlotId(slotId);
                slotId++;
                if(field.isLongOrDouble()){
                    slotId++;
                }
            }
        }
        aClass.setStaticSlotCount(slotId);
    }

    private void calcInstanceFieldSlotIds(Class aClass) {
        int slotId = 0;
        if (aClass.getSuperClass() != null) {
            slotId = aClass.getSuperClass().getInstanceSlotCount();
        }
        for(Field field:aClass.getFields()){
            if(!field.getClassMember().isStatic()){
                field.setSlotId(slotId);
                slotId++;
                if(field.isLongOrDouble()){
                    slotId++;
                }
            }
        }
        aClass.setInstanceSlotCount(slotId);
    }

    private void verify(Class aClass) {
        return;
    }

    private Class defineClass(byte[] data){
        Class _class = parseClass(data);
        _class.setClassLoader(this);
        resolveSuperClass(_class);
        resolveInterfaces(_class);
        this.classMap.put(_class.getName(), _class);
        return _class;
    }

    private void resolveInterfaces(Class _class) {
        int interfaceCount = _class.getInterfaceNames().length;
        if(interfaceCount > 0){
            Class[] interfaces = new Class[interfaceCount];
            String[] interfaceNames = _class.getInterfaceNames();
            for(int i = 0;i < interfaceCount;i++){
                interfaces[i] = _class.getClassLoader().loadClass(interfaceNames[i]);
            }
            _class.setInterfaces(interfaces);
        }
    }

    private Class parseClass(byte[] data){
        ClassFile classFile = new ClassFile(data);
        return new Class(classFile);
    }

    public void resolveSuperClass(Class _class){
        if(!_class.getName().equals("java/lang/Object")){
            _class.setSuperClass(_class.getClassLoader().loadClass(_class.getSuperClassName()));
        }
        return;
    }

}
