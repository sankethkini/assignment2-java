package com.nuclei.assignment.services.userservice;

import com.nuclei.assignment.constants.DisplayConstants;
import com.nuclei.assignment.enums.Field;
import com.nuclei.assignment.enums.Order;
import com.nuclei.assignment.models.Course;
import com.nuclei.assignment.models.User;
import com.nuclei.assignment.services.storage.Storage;
import com.nuclei.assignment.utils.AddUser;
import com.nuclei.assignment.utils.InputValidators;
import com.nuclei.assignment.utils.ParseCourse;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserService {

  Scanner scan;
  Storage memory;
  Storage file;

  /**
   * create new user service.
   *
   * @param scan   - scanner for scanning user input.
   * @param memory - memory implementation.
   * @param file   - file implementation.
   */
  public UserService(Scanner scan, Storage memory, Storage file) {
    this.scan = scan;
    this.memory = memory;
    this.file = file;
  }

  /**
   * take user input for creating new user.
   */
  public void userInputAndAdd() {
    try {
      System.out.print(DisplayConstants.NAME_INPUT);
      final String userFullName = scan.nextLine();
      System.out.print(DisplayConstants.AGE_INPUT);
      final int userAge = scan.nextInt();
      scan.nextLine();
      System.out.print(DisplayConstants.ADDRESS_INPUT);
      final String userAddress = scan.nextLine();
      System.out.print(DisplayConstants.ROLL_INPUT);
      String userRollNo = scan.next();
      scan.nextLine();
      System.out.print(DisplayConstants.COURSE_INPUT);
      String userCourses = scan.nextLine().toUpperCase();
      List<Course> courses = ParseCourse.parse(userCourses);
      InputValidators.validate(this.memory, userFullName, userRollNo, userAddress, userAge);
      AddUser.add(memory, userFullName, userRollNo, userAddress, userAge, courses);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * save method is used to save from data structure to file storage.
   **/
  public void save() {
    try {
      List<User> users = memory.readAll(Field.NAME, Order.ASC);
      if (Objects.isNull(users)) {
        return;
      }
      this.file.save(users);
      System.out.println(DisplayConstants.SAVE_SUCCESS);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * exit is used to exit from application.
   */
  public void exit() {
    System.out.println(DisplayConstants.SAVE_CHANGES);
    System.out.print(DisplayConstants.YES_OR_NO);
    String op = scan.nextLine();
    if (op.toUpperCase().charAt(0) == DisplayConstants.YES_OPTION) {
      this.save();
    }
    System.out.println(DisplayConstants.EXITING);
  }

  /**
   * field input for display.
   * */
  public Field fieldInput() {
    System.out.println(DisplayConstants.LINE);
    System.out.println(DisplayConstants.SORT_FIELD);
    System.out.println(DisplayConstants.NAME);
    System.out.println(DisplayConstants.ADDRESS);
    System.out.println(DisplayConstants.ROLL);
    System.out.println(DisplayConstants.AGE);
    Integer op = scan.nextInt();
    Field field;
    switch (op) {
      case 2:
        field = Field.ADDRESS;
        break;
      case 3:
        field = Field.ROLL;
        break;
      case 4:
        field = Field.AGE;
        break;
      default:
        field = Field.NAME;
    }
    return field;
  }

  /**
   * order input for display.
   * */
  public Order orderInput() {
    Order order;
    System.out.println(
        DisplayConstants.ORDER_ENTER
            + DisplayConstants.ASC
            + DisplayConstants.DESC
    );
    Integer op = scan.nextInt();
    if (op == 1) {
      order = Order.ASC;
    } else {
      order = Order.DESC;
    }
    return order;
  }

  /**
   * display all users based on different field ordered by ascending or descending.
   */
  public void display() throws Exception {
    Field field;
    Order order;
    field = fieldInput();
    order = orderInput();
    List<User> users = this.memory.readAll(field, order);
    System.out.println(DisplayConstants.LINE);
    for (User u : users) {
      System.out.println(
          DisplayConstants.NAME + u.getName()
              + DisplayConstants.ADDRESS + u.getAddress()
              + DisplayConstants.ROLL + u.getRollNum()
              + DisplayConstants.AGE + u.getAge()
      );
    }
  }

  /**
   * delete is used delete a particular user.
   */
  public void delete() {
    System.out.println(DisplayConstants.LINE);
    System.out.print(DisplayConstants.ROLL_INPUT);
    String roll = this.scan.nextLine();
    User u = memory.delete(roll);
    if (Objects.isNull(u)) {
      System.out.println(DisplayConstants.NO_FOUND);
      return;
    }
    System.out.println(DisplayConstants.DEL_SUCCESS);
  }

}
