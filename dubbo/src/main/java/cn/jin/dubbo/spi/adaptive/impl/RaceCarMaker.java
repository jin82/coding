package cn.jin.dubbo.spi.adaptive.impl;

import cn.jin.dubbo.spi.adaptive.*;
import org.apache.dubbo.common.URL;

/**
 * Created by jin on 2019/2/21.
 */
public class RaceCarMaker implements CarMaker {

    private WheelMaker wheelMaker;

    private GlassMaker glassMaker;

    @Override
    public Car makeCar(URL url) {
        Wheel wheel = wheelMaker.makeWheel(url);
        Car car = new Car(wheel,url.getParameter("car.name"));
        car.setGlass(glassMaker.makeClass(url));
        return car;
    }

    public void setWheelMaker(WheelMaker wheelMaker) {
        this.wheelMaker = wheelMaker;
    }

    public void setGlassMaker(GlassMaker glassMaker) {
        this.glassMaker = glassMaker;
    }
}
