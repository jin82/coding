package cn.jin.k8s.kv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by jin on 2019-05-21.
 */
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
public class KvServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KvServerApplication.class, args);
    }


    @Configuration
    @ConditionalOnProperty(name = "type",havingValue = "redis")
    @Import(RedisAutoConfiguration.class)
    static class RedisConfig {
        @Bean
        public RedisKvServer redisKvServer(StringRedisTemplate template) {
            return new RedisKvServer(template);
        }
    }


    @Bean
    @ConditionalOnProperty(name = "type",havingValue = "memory",matchIfMissing = true)
    public MemoryKvServer memoryKvServer() {
        return new MemoryKvServer();
    }






}
