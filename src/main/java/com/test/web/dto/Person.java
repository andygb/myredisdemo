package com.test.web.dto;

import java.util.Date;
import java.util.List;

/**
 * Created by rick on 2017/4/5.
 */
public class Person {

  private int id;

  private String name;

  private int age;

  private Date brithday;

  private List<Person> classMetas;

  public Person() {
  }

  public Person(int id, String name, int age, Date brithday, List<Person> classMetas) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.brithday = brithday;
    this.classMetas = classMetas;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Date getBrithday() {
    return brithday;
  }

  public void setBrithday(Date brithday) {
    this.brithday = brithday;
  }

  public List<Person> getClassMetas() {
    return classMetas;
  }

  public void setClassMetas(List<Person> classMetas) {
    this.classMetas = classMetas;
  }

  @Override
  public String toString() {
    return com.google.common.base.MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("name", name)
        .add("age", age)
        .add("brithday", brithday)
        .add("classMetas", classMetas)
        .toString();
  }

}
