package com.test.web.service;

import com.test.web.dto.Person;
import java.util.List;

/**
 * Created by rick on 2017/4/7.
 */
public interface UserService {

  Person getPersonByName(String name);

  List<Person> getPersonListByName(String name);

}
