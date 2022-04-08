package com.nuclei.assignment;

import com.nuclei.assignment.constants.DisplayConstants;
import com.nuclei.assignment.services.storage.Storage;
import com.nuclei.assignment.services.userservice.UserService;
import java.util.Scanner;

public class Application {
  private Storage file;
  private Storage memory;
  private final UserService userService;
  private final Scanner sc;

  /**
   * initialize file and memory storing.
   */
  public Application(UserService userService, Scanner sc) {
    this.userService = userService;
    this.sc = sc;
  }

  /**
   * run method is used to take input from user.
   * switch it to appropriate service function.
   */
  public void getUserInputAndAct() {
    try {
      boolean cont = true;
      do {
        System.out.println(DisplayConstants.LINE);
        System.out.print(
            DisplayConstants.SELECT_OPTION
                + DisplayConstants.NEW_USER
                + DisplayConstants.DISPLAY
                + DisplayConstants.DELETE
                + DisplayConstants.SAVE
                + DisplayConstants.EXIT
        );
        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
          case 1:
            userService.userInputAndAdd();
            break;
          case 2:
            userService.display();
            break;
          case 3:
            userService.delete();
            break;
          case 4:
            userService.save();
            break;
          case 5:
            userService.exit();
            cont = false;
            break;
          default:
            System.out.println(DisplayConstants.CORR_OPTION);
        }
        System.out.println(DisplayConstants.LINE);
      } while (cont);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.exit(0);
    } finally {
      this.sc.close();
    }

  }
}
