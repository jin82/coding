package cn.jin.coding.redis.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by jin on 2019/1/15.
 */
public class JedisConfiguration {


    @Bean
    public JedisCluster jedisCluster(@Value("${jedis.hosts}") List<String> redisUrls) {
        Set<HostAndPort> jedisClusterNodes = new HashSet<>();
        List<HostAndPort> collect = redisUrls.stream()
                .map(i -> i.split(":"))
                .map(url -> new HostAndPort(url[0], Integer.valueOf(url[1])))
                .collect(Collectors.toList());
        jedisClusterNodes.addAll(collect);
        return new JedisCluster(jedisClusterNodes);
    }

}
