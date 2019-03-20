package cn.jin.dubbo.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

/**
 * Created by jin on 2019/2/20.
 */
public class SpiTest {


    @Test
    public void testSpiSlot() {

        ExtensionLoader<Slot> slotExtensionLoader = ExtensionLoader.getExtensionLoader(Slot.class);
        Slot mockSlot = slotExtensionLoader.getExtension("mockSlot");
        Slot memorySlot = slotExtensionLoader.getExtension("memorySlot");
        mockSlot.put("Spi");
        memorySlot.put("Spi");

        System.out.println(mockSlot.getClass().getName() + " : " + mockSlot.get());
        System.out.println(memorySlot.getClass().getName() + " : " + memorySlot.get());


    }
}
