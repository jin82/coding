package cn.jin.spi.impl;

import cn.jin.spi.Repository;

/**
 * Created by jin on 2019/2/6.
 */
public class SimpleRepository<T> implements Repository<T> {

    private T t;

    @Override
    public void store(T t) {
        this.t = t;
    }

    @Override
    public T get() {
        return t;
    }

}
