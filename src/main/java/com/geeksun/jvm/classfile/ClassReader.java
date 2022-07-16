package com.geeksun.jvm.classfile;

import com.geeksun.jvm.util.Utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class ClassReader {
    private byte[] data;

    private int position;

    public ClassReader(byte[] data){
        this.data = data;
        this.position = 0;
    }

    public int nextU1toInteger(){
        return Utils.byteToInteger(new byte[]{data[position++]});
    }

    public int nextU2toInteger(){
        return Utils.byteToInteger(new byte[]{data[position++], data[position++]});
    }

    public int nextU4toInteger(){
        return Utils.byteToInteger(new byte[]{data[position++], data[position++], data[position++], data[position++]});
    }

    public float nextU4toFloat(){
        byte[] bytes = readBytes(4);
        return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getFloat();
    }

    public String nextU4ToHexString(){
        return Utils.byteToHexString(new byte[]{data[position++], data[position++], data[position++], data[position++]});
    }

    public long next2U4ToLong(){
        byte[] bytes = readBytes(8);
        return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getLong();
    }

    public double next2U4ToDouble(){
        byte[] bytes = readBytes(8);
        return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getDouble();
    }

    public int[] nextUint16s(){
        int count = nextU2toInteger();
        int[] res = new int[count];
        for(int i = 0;i < count;i++){
            res[i] = nextU2toInteger();
        }
        return res;
    }

    public byte[] readBytes(int length){
        position += length;
        return Arrays.copyOfRange(data, position - length, position);
    }


}
