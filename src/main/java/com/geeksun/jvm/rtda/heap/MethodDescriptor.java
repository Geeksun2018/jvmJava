package com.geeksun.jvm.rtda.heap;

import java.util.ArrayList;
import java.util.List;

public class MethodDescriptor {
    List<String> parameterTypes;
    String returnType;

    public MethodDescriptor(){
        parameterTypes = new ArrayList<>();
    }

    public void addParameterType(String type){
        this.parameterTypes.add(type);
    }


}
