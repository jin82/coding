package cn.jin.spring;

import java.io.File;

/**
 * Created by jin on 2019/1/31.
 */
public abstract class BaseTest {


    protected String getCurrentClassPathResource(String resourceName) {
        String name = this.getClass().getName();
        if (resourceName.startsWith("/") || resourceName.startsWith("\\")) {
            resourceName = resourceName.substring(1, resourceName.length());
        }
        return name.substring(0, name.lastIndexOf(".") + 1)
                .replace(".", File.separator)
                + resourceName;

    }



}

