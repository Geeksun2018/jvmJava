package com.geeksun.jvm.rtda;

import com.geeksun.jvm.rtda.heap.Object;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperandStack {
    private int size;
    private Slot[] slots;

    public OperandStack(int maxStack){
        slots = new Slot[maxStack];
        for(int i = 0;i < maxStack;i++){
            slots[i] = new Slot();
        }
        size = 0;
    }

    public void pushInt(int val){
        this.slots[size++].setNum(val);
    }

    public int popInt(){
        return slots[--size].getNum();
    }

    public void pushFloat(float val){
        int v = Float.floatToIntBits(val);
        pushInt(v);
    }

    public float popFloat(){
        int v = popInt();
        return Float.intBitsToFloat(v);
    }

    public void pushLong(long val){
        pushInt((int)val);
        pushInt((int)(val >> 32));
    }

    public long popLong(){
        long high = (popInt()&0x0000000ffffffffL) << 32;
        long low = popInt()&0x0000000ffffffffL;
        return low|high;
    }

    public void pushDouble(double val){
        long v = Double.doubleToLongBits(val);
        pushLong(v);
    }

    public double popDouble(){
        long v = popLong();
        return Double.longBitsToDouble(v);
    }

    public void pushRef(Object ref){
        this.slots[size++].setRef(ref);
    }

    public Object popRef(){
        Object ref = this.slots[--size].getRef();
        this.slots[size].setRef(null);
        return ref;
    }

    public void pushSlot(Slot slot){
        this.slots[size++] = slot;
    }

    public Slot popSlot(){
        return this.slots[--size];
    }

    public Object getRefFromTop(int n){
        return this.slots[size - 1 - n].getRef();
    }

}
