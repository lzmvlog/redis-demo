package com.shaojie.redisdemo.jedis;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author： ShaoJie
 * @data： 2020年01月30日 17:54
 * @Description： 使用 jedis 炒作 keys
 */
@Slf4j
public class TestKeys {

    @Test
    public void testKeys() {
        // 设置连接池的配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置连接池参数
        jedisPoolConfig.setMaxTotal(30);
        // 最大空闲数
        jedisPoolConfig.setMaxIdle(10);
        // 获取连接池对象
        @Cleanup JedisPool jedisPool = new JedisPool(jedisPoolConfig, "120.78.189.213", 6379);
        // 客户端对象
        @Cleanup Jedis jedis = jedisPool.getResource();
        jedis.auth("123456");

        log.info("操作命令  --- redis返回的信息");
        //log.info("清空数据库 flushdb --- {}",jedis.flushDB());
        // 存在返回 true 否则 flase
        // log.info("判断值是否存在 exists --- {}",jedis.exists("name"));
        log.info("判断值是否存在 exists --- {}",jedis.exists("name"));
    }

}
