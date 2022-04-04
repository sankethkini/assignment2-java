package assign2.services.memory;

import assign2.enums.Field;
import assign2.enums.Order;
import assign2.models.User;
import assign2.services.storage.MemoryImpl;
import assign2.services.storage.Storage;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemoryImplTest {
  private Storage memory;

  // for testing
  private final User a = new User("some2", 12, "some address1", "12s", null);
  private final User b = new User("some1", 14, "some address2", "13s", null);

  @BeforeEach
  public void init() {
    memory = new MemoryImpl();
  }

  @Test
  @DisplayName("check if users are saving correctly in order")
  public void testSave() {
    User[] users = new User[2];
    users[0] = a;
    users[1] = b;
    List<User> users1= Arrays.asList(users);
    Assertions.assertDoesNotThrow(
        ()->{
          memory.save(users1);
        }
    );


    // ordering users by name
    users[0] = b;
    users[1] = a;

    List<User> users2 = memory.readAll(Field.NAME, Order.ASC);
    User[] arr = users1.toArray(new User[0]);
    Assertions.assertArrayEquals(users, arr);
  }

  @Test
  @DisplayName("check if display by age descending is correct")
  public void testDisplayByAgeDesc() {
    User[] users = new User[2];

    memory.save(a);
    memory.save(b);

    users[0] = b;
    users[1] = a;

    List<User> users1 = memory.readAll(Field.AGE, Order.DESC);
    User[] arr = users1.toArray(new User[0]);
    Assertions.assertArrayEquals(users, arr);
  }

  @Test
  @DisplayName("check if display by age ascending is correct")
  public void testDisplayByAgeAsc() {
    User[] users = new User[2];

    memory.save(b);
    memory.save(a);

    users[0] = a;
    users[1] = b;

    List<User> users1 = memory.readAll(Field.AGE, Order.ASC);
    User[] arr = users1.toArray(new User[0]);
    Assertions.assertArrayEquals(users, arr);
  }

  @Test
  @DisplayName("check if display by address descending is correct")
  public void testDisplayByAddressDesc() {
    User[] users = new User[2];

    memory.save(a);
    memory.save(b);

    users[0] = b;
    users[1] = a;

    List<User> users1 = memory.readAll(Field.ADDRESS, Order.DESC);
    User[] arr = users1.toArray(new User[0]);
    Assertions.assertArrayEquals(users, arr);
  }

  @Test
  @DisplayName("check if display by address ascending is correct")
  public void testDisplayByAddressAsc() {
    User[] users = new User[2];

    memory.save(b);
    memory.save(a);

    users[0] = a;
    users[1] = b;

    List<User> users1 = memory.readAll(Field.ADDRESS, Order.ASC);
    User[] arr = users1.toArray(new User[0]);
    Assertions.assertArrayEquals(users, arr);
  }

  @Test
  @DisplayName("check if display by roll number descending is correct")
  public void testDisplayByRollDesc() {
    User[] users = new User[2];

    memory.save(a);
    memory.save(b);

    users[0] = b;
    users[1] = a;

    List<User> users1 = memory.readAll(Field.ROLL, Order.DESC);
    User[] arr = users1.toArray(new User[0]);
    Assertions.assertArrayEquals(users, arr);
  }

  @Test
  @DisplayName("check if display by roll number ascending is correct")
  public void testDisplayByRollAsc() {
    User[] users = new User[2];

    memory.save(b);
    memory.save(a);

    users[0] = a;
    users[1] = b;

    List<User> users1 = memory.readAll(Field.ROLL, Order.ASC);
    User[] arr = users1.toArray(new User[0]);
    Assertions.assertArrayEquals(users, arr);
  }

  @Test
  @DisplayName("check if users are saving correctly in order single user")
  public void testSaveSingle() {
    User[] users = new User[2];

    memory.save(a);
    memory.save(b);

    // ordering users by name
    users[0] = b;
    users[1] = a;

    List<User> users1 = memory.readAll(Field.NAME, Order.ASC);
    User[] arr = users1.toArray(new User[0]);
    Assertions.assertArrayEquals(users, arr);
  }

  @Test
  @DisplayName("check deletion if user is present")
  public void testDeletePresent() {
    memory.save(a);
    User ret = memory.delete("12s");
    Assertions.assertEquals(ret.getRollNum(), a.getRollNum());
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
    memory.save(a);
    User ret = memory.read("12s");
    Assertions.assertEquals(ret.getRollNum(), a.getRollNum());
  }

  @Test
  @DisplayName("check read if user is not present")
  public void testReadNotPresent() {
    User ret = memory.read("12s");
    Assertions.assertNull(ret);
  }

}
