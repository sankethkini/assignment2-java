package com.nuclei.assignment;

public class Main {
  /**
   * create a new application and run it.
   **/
  public static void main(String[] args) {
    try {
      Application application = new Application();
      application.run();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
