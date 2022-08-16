package com.geeksun.jvm.rtda.heap;

import com.geeksun.jvm.rtda.Slot;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Object {
    private Class _class;
    private Slot[] fields;

    public Object(Class _class){
        this._class = _class;
        fields = new Slot[_class.getInstanceSlotCount()];
    }

    public boolean isInstanceOf(Class _class){
        return _class.isAssignableFrom(this._class);
    }

}
