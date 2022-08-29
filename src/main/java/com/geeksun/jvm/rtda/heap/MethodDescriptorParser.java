package com.geeksun.jvm.rtda.heap;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class MethodDescriptorParser {
    private String raw;
    private int offset;
    private MethodDescriptor parsed;

    public MethodDescriptorParser(String descriptor){
        this.raw = descriptor;
        this.parsed = new MethodDescriptor();
        this.startParams();
        this.parseParamsTypes();
        this.endParams();
        this.parseReturnType();
        this.finish();
    }

    private void startParams(){
        if(this.readUint8() != '('){
            this.causePanic();
        }
    }

    public void endParams(){
        if(this.readUint8() != ')'){
            this.causePanic();
        }
    }

    public void finish(){
        if(this.offset != this.raw.length()){
            causePanic();
        }
    }

    public void parseParamsTypes(){
        while (true){
            String t = this.parseFieldType();
            if (!Objects.equals(t, "")) {
                this.parsed.addParameterType(t);
            }else{
                break;
            }
        }
    }

    public void parseReturnType(){
        if(this.readUint8() == 'V'){
            this.parsed.returnType = "V";
            return;
        }
        this.unreadUint8();
        String t = this.parseFieldType();
        if(!Objects.equals(t, "")){
            this.parsed.returnType = t;
            return;
        }
        this.causePanic();
    }

    public int readUint8(){
        return this.raw.charAt(offset++);
    }

    public void unreadUint8(){
        this.offset--;
    }

    public void causePanic(){
        System.out.println("BAD descriptor: " + this.raw);
    }

    public String parseFieldType(){
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
//                return this.pa
        }
        return "";
    }

    public String parseObjectType(){
        String unread = this.raw.substring(offset);
        int semicolonIndex = unread.indexOf(';');
        if(semicolonIndex == -1){
            this.causePanic();
            return "";
        }else{
            int objStart = this.offset - 1;
            int objEnd = this.offset + semicolonIndex + 1;
            this.offset = objEnd;
            return this.raw.substring(objStart, objEnd);
        }
    }

    public String parseArrayType(){
        int arrStart = this.offset - 1;
        this.parseFieldType();
        int arrEnd = this.offset;
        return this.raw.substring(arrStart, arrEnd);
    }

}
