package com.nuclei.assignment.services.storage;

import com.nuclei.assignment.enums.Field;
import com.nuclei.assignment.enums.Order;
import com.nuclei.assignment.models.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemoryImplTest {
  // for testing
  private final User user1 = new User("some2", 12, "some address1", "12s", null);
  private final User user2 = new User("some1", 14, "some address2", "13s", null);
  private Storage memory;

  @BeforeEach
  public void init() throws Exception {
    memory = new MemoryImpl(null);
  }

  @Test
  @DisplayName("check if users are saving correctly in order")
  public void testSave() {
    User[] users = new User[2];
    users[0] = user1;
    users[1] = user2;
    List<User> users1 = Arrays.asList(users);
    Assertions.assertDoesNotThrow(
        () -> {
          memory.save(users1);
        }
    );


    // ordering users by name
    users[0] = user2;
    users[1] = user1;

    List<User> users2 = Assertions.assertDoesNotThrow(() -> {
      return memory.readAll(Field.NAME, Order.ASC);
    });
    User[] arr = users2.toArray(new User[0]);
    Assertions.assertArrayEquals(users, arr);
  }

  @Test
  @DisplayName("check if display by age descending is correct")
  public void testDisplayByAgeDesc() {


    List<User> users1 = new ArrayList<>();
    users1.add(user1);
    users1.add(user2);
    Assertions.assertDoesNotThrow(
        () -> {
          memory.save(users1);
        }
    );

    User[] users = new User[2];
    users[0] = user2;
    users[1] = user1;

    List<User> users2 = Assertions.assertDoesNotThrow(() -> {
      return memory.readAll(Field.AGE, Order.DESC);
    });
    User[] arr = users2.toArray(new User[0]);
    Assertions.assertArrayEquals(users, arr);
  }

  @Test
  @DisplayName("check if display by age ascending is correct")
  public void testDisplayByAgeAsc() {


    List<User> users1 = new ArrayList<>();
    users1.add(user2);
    users1.add(user1);
    Assertions.assertDoesNotThrow(
        () -> {
          memory.save(users1);
        }
    );

    User[] users = new User[2];
    users[0] = user1;
    users[1] = user2;

    List<User> users2 = Assertions.assertDoesNotThrow(() -> {
      return memory.readAll(Field.AGE, Order.ASC);
    });
    User[] arr = users2.toArray(new User[0]);
    Assertions.assertArrayEquals(users, arr);
  }

  @Test
  @DisplayName("check if display by address descending is correct")
  public void testDisplayByAddressDesc() {


    List<User> users1 = new ArrayList<>();
    users1.add(user1);
    users1.add(user2);
    Assertions.assertDoesNotThrow(
        () -> {
          memory.save(users1);
        }
    );

    User[] users = new User[2];
    users[0] = user2;
    users[1] = user1;

    List<User> users2 = Assertions.assertDoesNotThrow(() -> {
      return memory.readAll(Field.ADDRESS, Order.DESC);
    });
    User[] arr = users2.toArray(new User[0]);
    Assertions.assertArrayEquals(users, arr);
  }

  @Test
  @DisplayName("check if display by address ascending is correct")
  public void testDisplayByAddressAsc() {


    List<User> users1 = new ArrayList<>();
    users1.add(user2);
    users1.add(user1);
    Assertions.assertDoesNotThrow(
        () -> {
          memory.save(users1);
        }
    );

    User[] users = new User[2];
    users[0] = user1;
    users[1] = user2;

    List<User> users2 = Assertions.assertDoesNotThrow(() -> {
      return memory.readAll(Field.ADDRESS, Order.ASC);
    });
    User[] arr = users2.toArray(new User[0]);
    Assertions.assertArrayEquals(users, arr);
  }

  @Test
  @DisplayName("check if display by roll number descending is correct")
  public void testDisplayByRollDesc() {


    List<User> users1 = new ArrayList<>();
    users1.add(user1);
    users1.add(user2);
    Assertions.assertDoesNotThrow(
        () -> {
          memory.save(users1);
        }
    );

    User[] users = new User[2];
    users[0] = user2;
    users[1] = user1;

    List<User> users2 = Assertions.assertDoesNotThrow(() -> {
      return memory.readAll(Field.ROLL, Order.DESC);
    });
    User[] arr = users2.toArray(new User[0]);
    Assertions.assertArrayEquals(users, arr);
  }

  @Test
  @DisplayName("check if display by roll number ascending is correct")
  public void testDisplayByRollAsc() {


    List<User> users1 = new ArrayList<>();
    users1.add(user2);
    users1.add(user1);
    Assertions.assertDoesNotThrow(
        () -> {
          memory.save(users1);
        }
    );

    User[] users = new User[2];
    users[0] = user1;
    users[1] = user2;

    List<User> users2 = Assertions.assertDoesNotThrow(() -> {
      return memory.readAll(Field.ROLL, Order.ASC);
    });
    User[] arr = users2.toArray(new User[0]);
    Assertions.assertArrayEquals(users, arr);
  }

  @Test
  @DisplayName("check if users are saving correctly in order single user")
  public void testSaveSingle() {


    List<User> users1 = new ArrayList<>();
    users1.add(user1);
    Assertions.assertDoesNotThrow(
        () -> {
          memory.save(users1);
        }
    );
    users1.set(0, user2);
    Assertions.assertDoesNotThrow(
        () -> {
          memory.save(users1);
        }
    );

    // ordering users by name
    User[] users = new User[2];
    users[0] = user2;
    users[1] = user1;

    List<User> users2 = Assertions.assertDoesNotThrow(() -> {
      return memory.readAll(Field.NAME, Order.ASC);
    });
    User[] arr = users2.toArray(new User[0]);
    Assertions.assertArrayEquals(users, arr);
  }

  @Test
  @DisplayName("check deletion if user is present")
  public void testDeletePresent() {
    List<User> users1 = new ArrayList<>();
    users1.add(user1);
    Assertions.assertDoesNotThrow(
        () -> {
          memory.save(users1);
        }
    );
    User ret = memory.delete("12s");
    Assertions.assertEquals(ret.getRollNum(), user1.getRollNum());
  }

  @Test
  @DisplayName("check deletion if user is not present")
  public void testDeleteNotPresent() {
    User ret = memory.delete("12s");
    Assertions.assertNull(ret);
  }


  @Test
  @DisplayName("check read for user is present")
  public void testReadPresent() {
    List<User> users1 = new ArrayList<>();
    users1.add(user1);
    Assertions.assertDoesNotThrow(
        () -> {
          memory.save(users1);
        }
    );
    User ret = memory.read("12s");
    Assertions.assertEquals(ret.getRollNum(), user1.getRollNum());
  }

  @Test
  @DisplayName("check read if user is not present")
  public void testReadNotPresent() {
    User ret = memory.read("12s");
    Assertions.assertNull(ret);
  }

}
