package com.geeksun.jvm.rtda;

public class LocalVars {
    private Slot[] localVars;

    public LocalVars(int maxLocals){
        if(maxLocals > 0){
            localVars = new Slot[maxLocals];
        }
    }

    public void setInt(int index, int val){
        localVars[index].setNum(val);
    }

    public int getInt(int index){
        return localVars[index].getNum();
    }

    public void setFloat(int index, float val){
        int iVal = Float.floatToIntBits(val);
        setInt(index, iVal);
    }

    public float getFloat(int index){
        return Float.intBitsToFloat(getInt(index));
    }

    public void setLong(int index, long val){

    }

}
