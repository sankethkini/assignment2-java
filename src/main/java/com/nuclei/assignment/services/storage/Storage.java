package assign2.services.storage;

import assign2.enums.Field;
import assign2.enums.Order;
import assign2.models.User;
import java.util.List;

public interface Storage {
  void save(List<User> users) throws Exception;

  List<User> readAll(Field field, Order order) throws Exception;

  User read(String rollNum);

  User delete(String rollNum);
}
