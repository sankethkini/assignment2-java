package com.nuclei.assignment;

import com.nuclei.assignment.constants.DisplayConstants;
import com.nuclei.assignment.constants.FileConstants;
import com.nuclei.assignment.enums.Field;
import com.nuclei.assignment.enums.Order;
import com.nuclei.assignment.models.User;
import com.nuclei.assignment.services.storage.FileStorage;
import com.nuclei.assignment.services.storage.MemoryImpl;
import com.nuclei.assignment.services.storage.Storage;
import com.nuclei.assignment.services.userservice.UserService;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Application {
  private Storage file;
  private Storage memory;
  private UserService userService;
  private Scanner sc;

  /**
   * initialize file and memory storing.
   */
  public Application() throws Exception {
    this.file = new FileStorage(FileConstants.FILE_NAME);
    this.memory = new MemoryImpl();
    List<User> users = file.readAll(Field.NAME, Order.ASC);

    if (Objects.nonNull(users) && users.size() != 0) {
      this.memory.save(users);
    }

    this.sc = new Scanner(System.in);
    this.userService = new UserService(sc, memory, file);
  }

  /**
   * run method is used to take input from user.
   * switch it to appropriate service function.
   */
  public void run() {
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
            userService.userInput();
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
