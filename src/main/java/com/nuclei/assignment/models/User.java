package com.nuclei.assignment.models;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
  private final String name;
  private final Integer age;
  private final String address;
  private final String rollNum;
  private final List<Course> courses;

  public User(String name, Integer age, String address, String rollNum, List<Course> courses) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.rollNum = rollNum;
    this.courses = courses;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }

  public String getRollNum() {
    return rollNum;
  }

  public List<Course> getCourses() {
    return courses;
  }
}
