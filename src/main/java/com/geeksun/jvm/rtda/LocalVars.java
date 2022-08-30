package com.geeksun.jvm.rtda;

import com.geeksun.jvm.rtda.heap.Object;

public class LocalVars {
    private Slot[] localVars;

    public LocalVars(int maxLocals){
        if(maxLocals > 0){
            localVars = new Slot[maxLocals];
            for(int i = 0;i < maxLocals;i++){
                localVars[i] = new Slot();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Slot localVar : localVars) {
            sb.append(localVar).append(" ");
        }
        return sb.toString();
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
        setInt(index, (int)val);
        setInt(index + 1, (int)(val >> 32));
    }

    public long getLong(int index){
        long low = getInt(index)&0x0000000ffffffffL;
        long high = (getInt(index + 1)&0x0000000ffffffffL) << 32;
        return low|high;
    }

    public void setDouble(int index, double val){
        long v = Double.doubleToLongBits(val);
        setLong(index, v);
    }

    public Double getDouble(int index){
        return Double.longBitsToDouble(getLong(index));
    }

    public void setRef(int index, Object object){
        localVars[index].setRef(object);
    }

    public Object getRef(int index){
        return localVars[index].getRef();
    }

    public void setSlot(int index, Slot slot){
        localVars[index] = slot;
    }

}
