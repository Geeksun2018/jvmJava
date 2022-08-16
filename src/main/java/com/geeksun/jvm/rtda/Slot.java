package com.geeksun.jvm.rtda;

import com.geeksun.jvm.rtda.heap.Object;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Slot {
    private int num;
    private Object ref;
}
