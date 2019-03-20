package cn.jin.dubbo.spi;

import cn.jin.dubbo.spi.adaptive.Car;
import cn.jin.dubbo.spi.adaptive.CarMaker;
import cn.jin.dubbo.spi.adaptive.Wheel;
import cn.jin.dubbo.spi.adaptive.WheelMaker;
import cn.jin.dubbo.spi.adaptive.impl.BmwWheelMaker;
import cn.jin.dubbo.spi.adaptive.impl.WulinWheelMaker;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jin on 2019/2/21.
 */
public class AdaptiveTest {

    @Test
    public void testUrl() {
        Assert.assertEquals(getBmwUrl().getParameter("wheel.maker"), "bmwWheelMaker");
        Assert.assertEquals(getWulinUrl().getParameter("wheel.maker"), "wulinWheelMaker");
    }


    @Test
    public void adaptiveBmwTest() {
        ExtensionLoader<WheelMaker> extensionLoader = ExtensionLoader.getExtensionLoader(WheelMaker.class);

        WheelMaker adaptiveExtension = extensionLoader.getAdaptiveExtension();
        Wheel wheel = adaptiveExtension.makeWheel(getBmwUrl());
        Assert.assertSame(wheel.getName(), BmwWheelMaker.NAME);
        Assert.assertSame(wheel.getType(), 1);

    }

    @Test
    public void adaptiveWulinTest() {
        ExtensionLoader<WheelMaker> extensionLoader = ExtensionLoader.getExtensionLoader(WheelMaker.class);

        WheelMaker adaptiveExtension = extensionLoader.getAdaptiveExtension();
        Wheel wheel = adaptiveExtension.makeWheel(getWulinUrl());
        Assert.assertSame(wheel.getName(), WulinWheelMaker.NAME);
        Assert.assertSame(wheel.getType(), 1);
    }

    @Test
    public void adaptiveIntegrationTest() {
        ExtensionLoader<WheelMaker> extensionLoader = ExtensionLoader.getExtensionLoader(WheelMaker.class);

        WheelMaker adaptiveExtension = extensionLoader.getAdaptiveExtension();
        Wheel wheel = adaptiveExtension.makeWheel(getWulinUrl());
        Assert.assertSame(wheel.getName(), WulinWheelMaker.NAME);
        Assert.assertSame(wheel.getType(), 1);

        Wheel bmwWheel = adaptiveExtension.makeOtherWheel(getBmwUrl());
        Assert.assertSame(bmwWheel.getName(), BmwWheelMaker.NAME);
        Assert.assertSame(bmwWheel.getType(), 1);
    }

    @Test
    public void testAdaptiveCar() {
        ExtensionLoader<CarMaker> extensionLoader = ExtensionLoader.getExtensionLoader(CarMaker.class);
        CarMaker carMaker = extensionLoader.getDefaultExtension();
        URL url = getUrl()
                .addParameter("car.name", "五菱宏光")
                .addParameter("wheel.maker", "bmwWheelMaker");
//                .addParameter("glass", "default");
        Car car = carMaker.makeCar(url);
        Assert.assertEquals(car.getName(),url.getParameter("car.name"));
        Assert.assertEquals(car.getWheel().getName(), BmwWheelMaker.NAME);
    }



    private URL getBmwUrl() {
        URL url = getUrl()
        .addParameter("wheel.maker", "bmwWheelMaker");
        return url;
    }

    private URL getWulinUrl() {
        URL url = getUrl()
        .addParameter("wheel.maker", "wulinWheelMaker");
        return url;
    }



    private URL getUrl() {
        URL url = new URL("dubbo", "172.16.10.30", 20880)
        .setPath("testWheelMaker")
        .addParameter("wheel.type", 1);
        return url;
    }

}
