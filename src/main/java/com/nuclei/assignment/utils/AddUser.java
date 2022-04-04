package com.nuclei.assignment.utils;

import com.nuclei.assignment.constants.DisplayConstants;
import com.nuclei.assignment.models.Course;
import com.nuclei.assignment.models.User;
import com.nuclei.assignment.services.storage.Storage;
import java.util.ArrayList;
import java.util.List;

public class AddUser {
  public static void add(Storage memory, String name, String rollNum, String address, Integer age,
                         String input)
      throws Exception {
    InputValidators.validate(name, rollNum, address, age);
    CheckIfRollExists.check(memory, rollNum);
    List<Course> courses = ParseCourse.parse(input);

    User u = new User(name, age, address, rollNum, courses);
    List<User> users = new ArrayList<>();
    users.add(u);
    memory.save(users);
    System.out.println(DisplayConstants.userSaved);
  }
}
