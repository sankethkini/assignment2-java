package com.nuclei.assignment;

import com.nuclei.assignment.constants.FileConstants;
import com.nuclei.assignment.services.storage.FileStorage;
import com.nuclei.assignment.services.storage.MemoryImpl;
import com.nuclei.assignment.services.storage.Storage;
import com.nuclei.assignment.services.userservice.UserService;
import java.util.Scanner;

public class Main {
  /**
   * main function calls initiate and runs application.
   * */
  public static void main(String[] args) {
    try {
      Main main = new Main();
      Application application = main.intializeApplication();
      application.getUserInputAndAct();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * create a new application.
   **/
  public Application intializeApplication() throws Exception {
    Storage file = new FileStorage(FileConstants.FILE_NAME);
    Storage memory = new MemoryImpl(file);
    Scanner sc = new Scanner(System.in);
    UserService userService = new UserService(sc, memory, file);
    Application application = new Application(userService, sc);
    return application;
  }
}
