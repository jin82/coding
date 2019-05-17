package cn.jin82.pool;

import cn.jin82.pool.domain.TimeConsumingObject;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * Created by jin on 2019-05-17.
 */
public class TimeConsumingObjectPoolFactory extends BasePooledObjectFactory<TimeConsumingObject> {

    private Supplier<String> nameSupplier;

    public TimeConsumingObjectPoolFactory() {
        this.nameSupplier = () -> UUID.randomUUID().toString();
    }

    public TimeConsumingObjectPoolFactory(Supplier<String> nameSupplier) {
        Objects.requireNonNull(nameSupplier);
        this.nameSupplier = nameSupplier;
    }

    @Override
    public TimeConsumingObject create() throws Exception {
        return new TimeConsumingObject(nameSupplier.get());
    }

    @Override
    public void destroyObject(PooledObject<TimeConsumingObject> p) throws Exception {
        p.getObject().destroy();
    }

    @Override
    public boolean validateObject(PooledObject<TimeConsumingObject> p) {
        return p.getObject().isCanBeUse();
    }

    @Override
    public PooledObject<TimeConsumingObject> wrap(TimeConsumingObject timeConsumingObject) {
        return new DefaultPooledObject<>(timeConsumingObject);
    }

}
