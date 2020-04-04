package com.example.demo.config.redis;

import redis.clients.jedis.Jedis;

public class RedisConfig {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 9527);
        jedis.incr("temp");
        System.out.println("这时第 " + jedis.get("temp") + " 次请求");
    }
}
