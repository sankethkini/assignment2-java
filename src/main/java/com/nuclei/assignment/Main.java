package com.nuclei.assignment;

public class Main {
  public static void main(String[] args) {
    try {
      Application application = new Application();
      application.run();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
