package com.nuclei.assignment.services.storage;

import com.nuclei.assignment.constants.CourseConstants;
import com.nuclei.assignment.enums.Field;
import com.nuclei.assignment.enums.Order;
import com.nuclei.assignment.models.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileStorageTest {

  FileStorage fileStorage = new FileStorage("usertest.ser");
  List<User> users = new ArrayList<>();

  @Test
  @DisplayName("check storing and reading from file")
  public void testIO() {
    users.add(new User("some", 12, "some address", "12s", CourseConstants.COURSES));
    Assertions.assertDoesNotThrow(
        () -> {
          fileStorage.save(users);
        }
    );

    Assertions.assertDoesNotThrow(
        () -> {
          List<User> ret = fileStorage.readAll(Field.NAME, Order.ASC);
          if (ret == null || ret.size() != users.size()) {
            throw new Exception("not equal");
          }

          for (int i = 0; i < users.size(); i++) {
            if (!users.get(i).getName().equals(ret.get(i).getName())) {
              throw new Exception("not equal");
            }
          }
        }
    );
  }
}
