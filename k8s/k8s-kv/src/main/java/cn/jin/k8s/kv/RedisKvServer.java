package cn.jin.k8s.kv;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by jin on 2019-05-21.
 */
@AllArgsConstructor
public class RedisKvServer implements KvServer{

    private StringRedisTemplate template;


    @Override
    public String get(String key) {
        return template.boundValueOps(key).get();
    }

    @Override
    public void put(String key, String value) {
        template.boundValueOps(key).set(value);
    }

    @Override
    public void remove(String key) {
        template.delete(key);

    }
}
