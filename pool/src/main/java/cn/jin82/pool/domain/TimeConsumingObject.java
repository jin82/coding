package cn.jin82.pool.domain;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by jin on 2019-05-17.
 */
@Getter
@ToString
public class TimeConsumingObject {

    private String name;

    private boolean canBeUse;

    private int useCount = 0;

    public TimeConsumingObject(String name) {
        this(name, true);
    }

    public void use() {
        System.out.println("used:" + ++useCount);
    }

    public TimeConsumingObject(String name, boolean canBeUse) {
        this.name = name;
        this.canBeUse = canBeUse;
        System.out.println("初始化对象： " + toString());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
        System.out.println("销毁对象： " + toString());
    }

    public boolean canBeUse() {
        return canBeUse;
    }


}
