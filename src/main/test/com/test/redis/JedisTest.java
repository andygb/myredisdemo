package com.test.redis;

import com.test.redis.jedis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

/**
 * Created by rick on 2017/4/5.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:config/*.xml")
public class JedisTest {

  @Autowired
  private RedisUtil redisUtil;

  @Test
  public void setValueTest() {

    for (int i = 0; i < 300000; i++) {
      try {
        redisUtil.setValue("hello" + i, "world" + i);
      } catch (Exception e) {
        System.out.println("当前已经插入了: " + i );
        e.printStackTrace();
        System.exit(0);
      }
    }
//    redisUtil.setValue("hello", "world");
  }

  @Test
  public void getValueTest() {

    String key = "hello179578";
    try {
      String value = redisUtil.getValue(key);
      if (StringUtils.isEmpty(value)) {
        System.out.println("redis has no value for your key");
      } else {
        System.out.println("value : " + value);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void batchDelValueTest() {

    for (int i = 0; i < 300000; i++) {
      try {
        boolean result = redisUtil.deleteKeyValue("hello"+i);
        System.out.println("删除第 " + i + " 条数据的结果:  " + result);
      }catch (Exception e) {
        System.out.println("当前已经删除了: " + i );
        e.printStackTrace();
        System.exit(0);
      }

    }
  }

  @Test
  public void delValueTest() {
    String key = "hello" + 199999;
    boolean result = redisUtil.deleteKeyValue(key);
    System.out.println("删除结果: " + result);
  }
}
