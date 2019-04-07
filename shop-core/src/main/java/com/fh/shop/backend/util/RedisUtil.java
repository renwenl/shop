package com.fh.shop.backend.util;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    public static void set (String key, String value){
        Jedis jedis = null;
        try {
            jedis = RedisPool.getResources();
            jedis.set(key,value);
        } finally {
            if (null != jedis){
                jedis.close();
                jedis = null;
            }
        }
    }

    public static void expire (String key, Integer seconds){
        Jedis jedis = null;
        try {
            jedis = RedisPool.getResources();
            jedis.expire(key,seconds);
        } finally {
            if (null != jedis){
                jedis.close();
                jedis = null;
            }
        }
    }

    public static String get (String key){
        Jedis jedis = null;
        String value = "";
        try {
            jedis = RedisPool.getResources();
            value = jedis.get(key);
        } finally {
            if (null != jedis){
                jedis.close();
                jedis = null;
            }
        }
        return  value;
    }

    public static void del(String key){
        Jedis jedis = null;
        try {
            jedis = RedisPool.getResources();
           jedis.del(key);
        } finally {
            if (null != jedis){
                jedis.close();
                jedis = null;
            }
        }
    }

}
