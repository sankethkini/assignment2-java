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
  private Storage storage;
  private Storage memory;
  private UserService userService;
  private Scanner sc;

  public Application() throws Exception {
    this.storage = new FileStorage(FileConstants.fileName);
    this.memory = new MemoryImpl();
    List<User> users = storage.readAll(Field.NAME, Order.ASC);

    if (Objects.nonNull(users) && users.size() != 0) {
      this.memory.save(users);
    }

    this.sc = new Scanner(System.in);
    this.userService = new UserService(sc, memory, storage);
  }

  public void run() {
    try {
      boolean cont = true;
      do {
        System.out.println(DisplayConstants.line);
        System.out.print(
            "Select a option\n"
                + "1. Add new user\n"
                + "2. Display all users\n"
                + "3. Delete user\n"
                + "4. Save user details\n"
                + "5. Exit"
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
            System.out.println("enter the correct option");
        }
        System.out.println(DisplayConstants.line);
      } while (cont);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.exit(0);
    } finally {
      this.sc.close();
    }

  }
}
