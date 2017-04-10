package com.test.redis.jedis;

import com.test.serialize.ProtostuffSerializer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by rick on 2017/4/5.
 */
@Service
public class RedisUtil {

  @Autowired
  private ShardedJedisPool shardedJedisPool;

  public void setValue(String key, String value) {
    ShardedJedis shardedJedis = shardedJedisPool.getResource();
    shardedJedis.set(key, value);
//    shardedJedisPool.returnResource(shardedJedis);
    shardedJedis.close();
  }

  public String getValue(String key) {
    String value = null;
    ShardedJedis shardedJedis = shardedJedisPool.getResource();
    value = shardedJedis.get(key);
//    shardedJedisPool.returnResource(shardedJedis);
    shardedJedis.close();
    return value;
  }

  public boolean setValue(String key, byte[] value) {
    if (StringUtils.isEmpty(key) || value == null) {
      return false;
    }

    try {
      byte[] byteKey = key.getBytes("UTF-8");
      if (byteKey != null && byteKey.length > 0) {
        String redisResult = shardedJedisPool.getResource().set(byteKey, value);

        if ("OK".equals(redisResult)) {
          return true;
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

    return false;
  }

  public boolean deleteKeyValue(String key) {
    ShardedJedis shardedJedis = shardedJedisPool.getResource();

    try {
      long redisResult = shardedJedis.del(key);
      if (redisResult > 0) {
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      shardedJedis.close();
    }

    return false;
  }

  public <T> boolean setObjectValue(String key, T value) {
    ShardedJedis shardedJedis = null;
    try {
      shardedJedis = shardedJedisPool.getResource();
      ProtostuffSerializer protobuf = new ProtostuffSerializer();
      byte[] valueByte = protobuf.serialize(value);
      byte[] keyByte = key.getBytes("utf-8");

      String jedisResult = shardedJedis.setex(keyByte, 3600, valueByte);
      if ("OK".equalsIgnoreCase(jedisResult)) {
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (shardedJedis != null) {
        shardedJedis.close();
      }
    }

    return false;
  }

  public <T> T getObjectValue(String key, Class<T> clazz) {
    ShardedJedis shardedJedis = null;
    try {
      shardedJedis = shardedJedisPool.getResource();
      byte[] keyByte = key.getBytes("utf-8");
      byte[] valueByte = shardedJedis.get(keyByte);

      if (valueByte != null && valueByte.length > 0) {
        ProtostuffSerializer protobuf = new ProtostuffSerializer();
        T objectT = protobuf.deserialize(valueByte, clazz);
        return objectT;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (shardedJedis != null) {
        shardedJedis.close();
      }
    }
    return null;
  }

}
