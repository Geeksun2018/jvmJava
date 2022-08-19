package com.geeksun.jvm.rtda.heap;

public class MethodDescriptorParser {
    private String raw;
    private int offset;
    private MethodDescriptor parsed;

    public MethodDescriptorParser(String descriptor){
        this.raw = descriptor;
        this.parsed = new MethodDescriptor();
        this.startParams();
        this.parseParamTypes();
    }

    private void parseParamTypes() {
        while(true){
            String t = this.parseFieldType();
            if(!t.equals("")){
                this.parsed.addParameterType(t);
            }else {
                break;
            }
        }

    }

    private void parseReturnType(){
        if(this.readUint8() == 'V'){
            this.parsed.returnType = "V";
            return;
        }
        this.unReadUint8();
        String t = this.parseFieldType();
        if(t.equals("")){
            this.parsed.returnType = t;
            return;
        }
        this.causePanic();

    }

    private String parseFieldType(){
        switch (this.readUint8()){
            case 'B':
                return "B";
            case 'C':
                return "C";
            case 'D':
                return "D";
            case 'F':
                return "F";
            case 'I':
                return "I";
            case 'J':
                return "J";
            case 'S':
                return "S";
            case 'Z':
                return "Z";
            case 'L':
                return this.parseObjectType();
            case '[':
                return this.parseArrayType();
            default:
                this.unReadUint8();
                return "";
                
        }
    }

    private String parseArrayType() {
        return "";
    }

    private String parseObjectType() {
        return null;
    }

    private void startParams() {
        if(this.readUint8() != '('){
            this.causePanic();
        }
    }

    private void endParams(){
        if(this.readUint8() != ')'){
            this.causePanic();
        }
    }

    private void finish(){
        if(this.offset != raw.length()){
            this.causePanic();
        }
    }

    private void causePanic(){
        System.out.println("panic");
    }

    private byte readUint8(){
        byte[] bytes = this.raw.getBytes();
        return bytes[offset++];
    }

    private void unReadUint8(){
        offset--;
    }



}
