package assign2.services.memory;

import assign2.enums.Field;
import assign2.enums.Order;
import assign2.models.User;

import java.sql.Savepoint;
import java.util.List;

public interface Memory {
    void save(User... user);
    List<User> readAll(Field field, Order order);
    User read(String rollNum);
    User delete(String rollNum);
}
