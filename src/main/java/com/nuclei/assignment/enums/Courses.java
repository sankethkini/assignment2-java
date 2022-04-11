package com.nuclei.assignment.enums;

public enum Courses {

  COURSE_A("A","name A"),

  COURSE_B("B","name B"),

  COURSE_C("C","name C"),

  COURSE_D("D","name D"),

  COURSE_E("E","name E"),

  COURSE_F("F","name F");

  private final String code;

  private final String name;

  Courses(String code, String name) {
    this.code = code;
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }


}
