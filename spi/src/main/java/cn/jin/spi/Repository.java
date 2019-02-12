package cn.jin.spi;

/**
 * Created by jin on 2019/2/6.
 */
public interface Repository<T> {

    void store(T t);

    T get();
}
