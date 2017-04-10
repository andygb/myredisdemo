package com.test.web.service.impl;

import com.test.redis.jedis.RedisUtil;
import com.test.web.dto.Person;
import com.test.web.service.UserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rick on 2017/4/7.
 */
@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private RedisUtil redisUtil;

  @Override
  public Person getPersonByName(String name) {

    String key = "classMetaList";
    Person person = redisUtil.getObjectValue(key, Person.class);
    if (person == null) {

      List<Person> list = new ArrayList();
      person = new Person(1, "Tom", 28, new Date(), new ArrayList<Person>());
      for (int i = 1; i <= 100; i++) {
        Person p = new Person(i, "name-" + i, 100-i, new Date(), new ArrayList<Person>());
        person.getClassMetas().add(p);
      }

      boolean result = redisUtil.setObjectValue(key, person);
    }
    return person;
  }

  @Override
  public List<Person> getPersonListByName(String name) {
    return null;
  }
}
