package cn.jin.dubbo.spi.adaptive.impl;

import cn.jin.dubbo.spi.adaptive.Wheel;
import cn.jin.dubbo.spi.adaptive.WheelMaker;
import org.apache.dubbo.common.URL;


/**
 * Created by jin on 2019/2/21.
 */
public class BmwWheelMaker implements WheelMaker {
    public static final String NAME = "BMW";
    @Override
    public Wheel makeWheel(URL url) {
        Wheel wheel = new Wheel();
        wheel.setName(NAME);
        wheel.setType(Integer.valueOf(url.getParameter("wheel.type")));
        return wheel;
    }

    @Override
    public Wheel makeOtherWheel(URL url) {
        return makeWheel(url);
    }
}
