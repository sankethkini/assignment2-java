package com.nuclei.assignment.services.storage;

import com.nuclei.assignment.enums.Field;
import com.nuclei.assignment.enums.Order;
import com.nuclei.assignment.models.User;
import com.nuclei.assignment.utils.Comparators;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoryImpl implements Storage {

  private final List<User> users;

  public MemoryImpl() {
    users = new ArrayList<>();
  }

  @Override
  public void save(List<User> users) {
    if (users.size() <= 1) {
      for (int i = 0; i < this.users.size(); i++) {
        if (this.users.get(i).getName().compareToIgnoreCase(users.get(0).getName()) >= 0) {
          this.users.add(i, users.get(0));
          return;
        }
      }
      this.users.add(users.get(0));
    } else {
      for (User u : users) {
        this.users.add(u);
      }
      Collections.sort(this.users, Comparators.NameComparator);
    }
  }

  @Override
  public List<User> readAll(Field field, Order order) {
    List<User> retUsers = users;
    switch (field) {
      case AGE:
        Collections.sort(retUsers, Comparators.AgeComparator);
      case ADDRESS:
        Collections.sort(retUsers, Comparators.AddressComparator);
      case ROLL:
        Collections.sort(retUsers, Comparators.RollNumComparator);
    }
    if (order == Order.DESC) {
      Collections.reverse(retUsers);
    }
    return retUsers;
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
    for (User u : this.users) {
      if (u.getRollNum().equals(rollNum)) {
        User del = u;
        this.users.remove(u);
        return del;
      }
    }
    return null;
  }
}
