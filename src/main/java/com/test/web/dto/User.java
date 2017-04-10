package com.test.web.dto;

import com.google.common.base.MoreObjects;

/**
 * Created by rick on 2017/4/7.
 */
public class User {

  private String name;

  private String password;

  public User() {
  }

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .add("password", password)
        .toString();
  }
}
