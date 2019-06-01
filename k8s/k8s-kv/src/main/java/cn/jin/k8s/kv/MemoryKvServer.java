package cn.jin.k8s.kv;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jin on 2019-05-21.
 */
public class MemoryKvServer implements KvServer{

    private final Map<String, String> store = new ConcurrentHashMap<>();

    @Override
    public String get(String key) {
        return store.get(key);
    }

    @Override
    public void put(String key, String value) {
        store.put(key, value);
    }

    @Override
    public void remove(String key) {
        store.remove(key);
    }
}
