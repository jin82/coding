package cn.jin.k8s.log;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by jin on 2019-05-23.
 */
@Repository
public class LogRepository {

    @Autowired
    @Setter
    private StringRedisTemplate stringRedisTemplate;


    public void save(String id, String content) {
        String key = "LogServer-" + id;
        initKeySet(key);
        Log log = new Log(id, content, new Date());
        stringRedisTemplate.opsForSet()
                .add(key, log.toJson());
    }

    public List<Log> list(String id) {
        Set<String> ids;
        final boolean rowKey;
        if (id == null) {
            ids = getKeySet();
            rowKey = false;
        } else {
            ids = Collections.singleton(id);
            rowKey = true;
        }
        return ids.stream().flatMap(i -> {
            String key = rowKey ? "LogServer-" + i : i;
            return stringRedisTemplate.opsForSet()
                    .members(key).stream();

        }).map(Log::toObject).collect(Collectors.toList());
    }

    public void clear(String id) {
        String key = "LogServer-" + id;
        stringRedisTemplate.delete(key);
    }

    private void initKeySet(String id) {
        stringRedisTemplate.opsForSet()
                .add("LogServer-keySet", id);
    }

    private Set<String> getKeySet() {
        return stringRedisTemplate.opsForSet()
                .members("LogServer-keySet");
    }



}

