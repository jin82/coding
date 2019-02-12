package cn.jin.spi.impl;

import cn.jin.spi.Repository;

/**
 * Created by jin on 2019/2/6.
 */
public class NonRepository<T> implements Repository<T> {
    @Override
    public void store(T t) {
        System.out.println("do nothing");
    }

    @Override
    public T get() {
        return null;
    }
}
