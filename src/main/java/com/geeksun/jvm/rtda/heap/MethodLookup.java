package com.geeksun.jvm.rtda.heap;

public class MethodLookup {

    public static Method lookupMethodInClass(Class aClass, String name, String descriptor){
        for(Class c = aClass;c != null;c = c.getSuperClass()){
            for(Method method:c.getMethods()){
                if(method.getClassMember().getName().equals(name)&&method.getClassMember().getDescriptor().equals(descriptor)){
                    return method;
                }
            }
        }
        return null;
    }

    public static Method lookupMethodInInterfaces(Class[] interfaces, String name, String descriptor){
        for(Class face:interfaces){
            for(Method method:face.getMethods()){
                if(method.getClassMember().getName().equals(name)&&method.getClassMember().getDescriptor().equals(descriptor)){
                    return method;
                }
            }
            Method method = lookupMethodInInterfaces(face.getInterfaces(), name, descriptor);
            if(method != null){
                return method;
            }
        }
        return null;
    }

}
