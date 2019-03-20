package cn.jin.dubbo.spi.impl;

import cn.jin.dubbo.spi.Slot;

/**
 * Created by jin on 2019/2/20.
 */
public class MockSlot implements Slot {

    @Override
    public void put(String o) {

    }

    @Override
    public String get() {
        return "mock";
    }
}
