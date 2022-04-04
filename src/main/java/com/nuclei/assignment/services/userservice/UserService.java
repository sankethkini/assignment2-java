package com.nuclei.assignment.services.userservice;

import com.nuclei.assignment.constants.DisplayConstants;
import com.nuclei.assignment.enums.Field;
import com.nuclei.assignment.enums.Order;
import com.nuclei.assignment.models.User;
import com.nuclei.assignment.services.storage.Storage;
import com.nuclei.assignment.utils.AddUser;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserService {

  Scanner scan;
  Storage memory;
  Storage file;

  public UserService(Scanner scan, Storage memory, Storage file) {
    this.scan = scan;
    this.memory = memory;
    this.file = file;
  }

  public void userInput() {
    try {
      System.out.print(DisplayConstants.nameInput);
      String userFullName = scan.nextLine();
      System.out.print(DisplayConstants.ageInput);
      int userAge = scan.nextInt();
      scan.nextLine();
      System.out.print(DisplayConstants.addressInput);
      String userAddress = scan.nextLine();
      System.out.print(DisplayConstants.rollInput);
      String userRollNo = scan.next();
      scan.nextLine();
      System.out.print(DisplayConstants.courseInput);
      String userCourses = scan.nextLine().toUpperCase();
      AddUser.add(memory, userFullName, userRollNo, userAddress, userAge, userCourses);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void save() {
    try {
      List<User> users = memory.readAll(Field.NAME, Order.ASC);
      if (Objects.isNull(users)) {
        return;
      }
      this.file.save(users);
      System.out.println("users saved successfully");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void exit() {
    System.out.println(DisplayConstants.saveChanges);
    System.out.print(DisplayConstants.yesOrNo);
    String op = scan.nextLine();
    if (op.charAt(0) == 'y' || op.charAt(0) == 'Y') {
      this.save();
    }
    System.out.println("Exiting .....");
  }

  public void display() throws Exception {
    System.out.println(DisplayConstants.line);
    System.out.println(
        "Enter the field by which you want to sort\n" +
            "1. Name\n" +
            "2. Address\n" +
            "3. Roll number\n" +
            "4. Age"
    );
    int op = scan.nextInt();
    Field field;
    Order order;
    switch (op) {
      case 1:
        field = Field.NAME;
      case 2:
        field = Field.ADDRESS;
      case 3:
        field = Field.ROLL;
      case 4:
        field = Field.AGE;
      default:
        field = Field.NAME;
    }
    System.out.println(
        "Enter the order\n" +
            "1. ascending\n" +
            "2. descending"
    );
    op = scan.nextInt();
    if (op == 1) {
      order = Order.ASC;
    } else {
      order = Order.DESC;
    }
    List<User> users = this.memory.readAll(field, order);
    System.out.println(DisplayConstants.line);
    for (User u : users) {
      System.out.println(
          "Name: " + u.getName() +
              " RollNum: " + u.getRollNum() +
              " Address: " + u.getAddress() +
              " Age: " + u.getAge()
      );
    }
  }

  public void delete() {
    System.out.println(DisplayConstants.line);
    System.out.print("Enter roll number");
    String roll = this.scan.nextLine();
    User u = memory.delete(roll);
    if (Objects.isNull(u)) {
      System.out.println("no such user found");
      return;
    }
    System.out.println("user deleted successfully");
  }

}
