package cn.jin.dubbo.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * Created by jin on 2019/2/20.
 */
@SPI
public interface Slot {

    void put(String o);

    String get();
}
