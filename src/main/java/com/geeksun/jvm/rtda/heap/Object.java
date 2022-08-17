package com.geeksun.jvm.rtda.heap;

import com.geeksun.jvm.rtda.LocalVars;
import com.geeksun.jvm.rtda.Slot;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Object {
    private Class _class;
    private LocalVars fields;

    public Object(Class _class){
        this._class = _class;
        fields = new LocalVars(_class.getInstanceSlotCount());
    }

    public boolean isInstanceOf(Class _class){
        return _class.isAssignableFrom(this._class);
    }

}
