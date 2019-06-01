package cn.jin.k8s.kv;

/**
 * Created by jin on 2019-05-21.
 */
public interface KvServer {

    String get(String key);

    void put(String key, String value);

    void remove(String key);
}
