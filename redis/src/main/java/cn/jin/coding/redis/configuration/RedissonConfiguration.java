package cn.jin.coding.redis.configuration;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * Created by jin on 2019/1/15.
 */
public class RedissonConfiguration {


    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient(@Value("${redisson.nodeAddress}")String[] nodeAddress) {
        Config config = new Config();
        config.setTransportMode(TransportMode.NIO);
        config.useClusterServers()
                .addNodeAddress(nodeAddress);

        return Redisson.create(config);
    }

}
