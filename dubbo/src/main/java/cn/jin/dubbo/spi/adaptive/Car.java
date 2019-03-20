package cn.jin.dubbo.spi.adaptive;

import lombok.Data;
import lombok.NonNull;

/**
 * Created by jin on 2019/2/21.
 */
@Data
public class Car {
    private @NonNull Wheel wheel;
    private @NonNull String name;
    private Glass glass;
}
