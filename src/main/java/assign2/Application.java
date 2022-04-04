package assign2;

import assign2.constants.DisplayConstants;
import assign2.constants.FileConstants;
import assign2.exceptions.FileReadException;
import assign2.models.User;
import assign2.services.memory.Memory;
import assign2.services.memory.MemoryImpl;
import assign2.services.storage.FileStorage;
import assign2.services.storage.Storage;
import assign2.services.userservice.Delete;
import assign2.services.userservice.Display;
import assign2.services.userservice.Exit;
import assign2.services.userservice.InteractiveInput;
import assign2.services.userservice.Save;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Application {
  private final Storage storage;
  private final Memory memory;

  public Application() throws FileReadException {
    this.storage = new FileStorage(FileConstants.fileName);
    this.memory = new MemoryImpl();
    List<User> users = storage.read();
    if (Objects.nonNull(users) && users.size() != 0) {
      User[] arr = users.toArray(new User[0]);
      this.memory.save(arr);
    }
  }

  public void run() {
    try (Scanner sc = new Scanner(System.in)) {
      boolean cont=true;
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
            InteractiveInput.run(sc, memory);
            break;
          case 2:
            Display.run(sc, memory);
            break;
          case 3:
            Delete.run(sc, memory);
            break;
          case 4:
            Save.run(storage, memory);
            break;
          case 5:
            Exit.run(sc, storage, memory);
            cont=false;
            break;
          default:
            System.out.println("enter the correct option");
        }
        System.out.println(DisplayConstants.line);
      } while (cont);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.exit(0);
    }
  }
}
