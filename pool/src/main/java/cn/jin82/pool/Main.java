package cn.jin82.pool;

import cn.jin82.pool.domain.TimeConsumingObject;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.util.stream.IntStream;

/**
 * Created by jin on 2019-05-17.
 */
public class Main {

    static ObjectPool<TimeConsumingObject> pool;

    public static void main(String[] args) throws Exception{
        GenericObjectPoolConfig<TimeConsumingObject> config = new GenericObjectPoolConfig<>();
        config.setMaxTotal(5);
        config.setTestOnBorrow(true);
        config.setMaxWaitMillis(3000);

        pool = new GenericObjectPool<>(new TimeConsumingObjectPoolFactory(), config);


        IntStream.range(1,100).parallel().forEach(index -> {
            try {
                use(index);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        pool.close();

    }

    public static void use(int index) throws Exception {
        TimeConsumingObject timeConsumingObject = pool.borrowObject();
        try{
            timeConsumingObject.use();
        }finally {
            pool.returnObject(timeConsumingObject);

        }
    }
}
