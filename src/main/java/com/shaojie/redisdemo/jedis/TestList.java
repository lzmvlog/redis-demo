package com.shaojie.redisdemo.jedis;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author： ShaoJie
 * @data： 2020年01月31日 19:09
 * @Description： 使用 jedis 操作 list 列表
 */
@Slf4j
public class TestList {

    @Test
    public void testList() {
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
        // 设置访问密码
        jedis.auth("123456");

        log.info("操作命令  --- redis返回的信息");
        // 添加数据 list 单个也行 多个也行 第一个是key 往后的都是 value
        // log.info("添加数据 lpush --- {}", jedis.lpush("key1", "value1", "value2", "value3"));
        // log.info("添加数据 list --- {}", jedis.lpush("key1", "value1"));
        // log.info("添加数据 list --- {}", jedis.lpush("key2", "value2"));
        // log.info("添加数据 list --- {}", jedis.lpush("key3", "value3"));
        // 获取数据 list 0 - -1 查看的是所有的值
        log.info("获取数据 lrange --- {}", jedis.lrange("key1", 0, -1));
        // 删除列表指定的数据 第二个参数为删除的个数 当有重复的值时 先添加的值 被先删除 类型出栈 第二个参数指定删除几个 第三个参数指定删除哪一个 value
        // log.info("获取数据 lrange --- {}", jedis.lrem("key1", 1, "value2"));
    }

}
