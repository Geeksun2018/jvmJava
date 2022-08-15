package com.geeksun.jvm.instructions.base;

import com.geeksun.jvm.util.Utils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BytecodeReader {
    byte[] code;
    int pc;

    public BytecodeReader(byte[] code, int pc){
        this.code = code;
        this.pc = pc;
    }

    public void reset(byte[] code, int pc){
        this.code = code;
        this.pc = pc;
    }

    public int readInt8(){
        int b1 = code[pc++];
        return b1 & 0xff;
    }

    public int readInt16(){
        int b1 = code[pc++];
        int b2 = code[pc++];
        return b1 << 8 | b2;
    }

    public int readInt32(){
        int b1 = code[pc++];
        int b2 = code[pc++];
        int b3 = code[pc++];
        int b4 = code[pc++];
        return b1 << 24 | b2 << 16 | b3 << 8 | b4;
    }

    public int[] readInt32s(int length){
        int[] res = new int[length];
        for(int i = 0;i < length;i++){
            res[i] = readInt32();
        }
        return res;
    }

    public void skipPadding(){
        while (pc % 4 != 0){
            readInt8();
        }
    }

}
