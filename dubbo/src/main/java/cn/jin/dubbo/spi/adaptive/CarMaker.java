package cn.jin.dubbo.spi.adaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.SPI;

/**
 * Created by jin on 2019/2/21.
 */
@SPI("race")
public interface CarMaker {

    Car makeCar(URL url);

}
