package cn.jin.dubbo.spi.adaptive;


import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * Created by jin on 2019/2/21.
 */
@SPI
public interface WheelMaker {

    @Adaptive
    Wheel makeWheel(URL url);

    @Adaptive
    Wheel makeOtherWheel(URL url);
}
