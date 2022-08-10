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

    public int[] readUint32s(int length){
        int[] res = new int[length];
        for(int i = 0;i < length;i++){
            res[i] = readUint32();
        }
        return res;
    }

    public void skipPadding(){
        while (pc % 4 != 0){
            readUint8();
        }
    }

}
