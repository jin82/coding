package cn.jin.dubbo.spi.adaptive.impl;

import cn.jin.dubbo.spi.adaptive.Glass;
import cn.jin.dubbo.spi.adaptive.GlassMaker;
import org.apache.dubbo.common.URL;

/**
 * Created by jin on 2019/2/21.
 */
public class DefaultGlassMaker implements GlassMaker {
    @Override
    public Glass makeClass(URL url) {
        return new Glass("default");
    }
}
