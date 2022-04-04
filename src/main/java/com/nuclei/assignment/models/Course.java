package assign2.models;

import java.io.Serializable;

public class Course implements Serializable {
  private final String code;
  private final String name;

  public Course(String code, String name) {
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
