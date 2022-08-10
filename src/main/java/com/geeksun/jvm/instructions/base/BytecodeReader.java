package com.geeksun.jvm.instructions.base;

import com.geeksun.jvm.util.Utils;

public class BytecodeReader {
    byte[] code;
    int pc;

    public void reset(byte[] code, int pc){
        this.code = code;
        this.pc = pc;
    }

    public int readUint8(){
        return Utils.byteToInteger(new byte[]{this.code[pc++]});
    }

    public int readUint16(){
        return Utils.byteToInteger(new byte[]{this.code[pc++], this.code[pc++]});
    }

    public int readUint32(){
        return Utils.byteToInteger(new byte[]{this.code[pc++], this.code[pc++], this.code[pc++], this.code[pc++]});
    }

}
