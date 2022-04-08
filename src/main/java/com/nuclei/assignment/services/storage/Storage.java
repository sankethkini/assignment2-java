package com.nuclei.assignment.services.storage;

import com.nuclei.assignment.enums.Field;
import com.nuclei.assignment.enums.Order;
import com.nuclei.assignment.models.User;
import java.util.List;

public interface Storage {
  void save(List<User> users) throws Exception;

  List<User> readAll(Field field, Order order) throws Exception;

  User read(String rollNum);

  User delete(String rollNum);
}
