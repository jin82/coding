package cn.jin.dubbo.spi.impl;

import cn.jin.dubbo.spi.Slot;

/**
 * Created by jin on 2019/2/20.
 */
public class MemorySlot implements Slot {
    private String s;

    @Override
    public void put(String o) {
        this.s = o;
    }

    @Override
    public String get() {
        return this.s;
    }
}
