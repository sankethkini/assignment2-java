package com.nuclei.assignment.services.storage;

import com.nuclei.assignment.enums.Field;
import com.nuclei.assignment.enums.Order;
import com.nuclei.assignment.models.User;
import com.nuclei.assignment.utils.Comparators;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MemoryImpl implements Storage {

  private final List<User> users;

  /**
   * construct new memory to save all users.
   * takes data from file and adds it to data structure.
   */
  public MemoryImpl(Storage file) throws Exception {
    this.users = new ArrayList<>();
    if (Objects.isNull(file)) {
      return;
    }
    List<User> users = file.readAll(Field.NAME, Order.ASC);
    if (Objects.nonNull(users) && users.size() != 0) {
      this.save(users);
    }
  }

  @Override
  public void save(List<User> inputUsers) {
    if (inputUsers.size() <= 1) {
      for (int i = 0; i < this.users.size(); i++) {
        if (this.users.get(i).getName().compareToIgnoreCase(inputUsers.get(0).getName()) >= 0) {
          this.users.add(i, inputUsers.get(0));
          return;
        }
      }
      this.users.add(inputUsers.get(0));
    } else {
      for (User u : inputUsers) {
        this.users.add(u);
      }
      Collections.sort(this.users, Comparators.NameComparator);
    }
  }

  @Override
  public List<User> readAll(Field field, Order order) {
    List<User> returnUsers = users;
    switch (field) {
      case AGE:
        Collections.sort(returnUsers, Comparators.AgeComparator);
        break;
      case ADDRESS:
        Collections.sort(returnUsers, Comparators.AddressComparator);
        break;
      case ROLL:
        Collections.sort(returnUsers, Comparators.RollNumComparator);
        break;
      default:
        returnUsers = users;
    }
    if (order == Order.DESC) {
      Collections.reverse(returnUsers);
    }
    return returnUsers;
  }

  @Override
  public User read(String rollNum) {
    for (User u : this.users) {
      if (u.getRollNum().equals(rollNum)) {
        return u;
      }
    }
    return null;
  }

  @Override
  public User delete(String rollNum) {
    User found = this.read(rollNum);
    if (Objects.isNull(found)) {
      return null;
    }
    this.users.remove(found);
    return found;
  }
}
