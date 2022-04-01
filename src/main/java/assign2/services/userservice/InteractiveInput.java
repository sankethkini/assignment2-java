package assign2.services.userservice;

import assign2.constants.CourseConstants;
import assign2.exceptions.CourseInputException;
import assign2.exceptions.InputValidatorException;
import assign2.exceptions.RollNumberExistsException;
import assign2.models.Course;
import assign2.models.User;
import assign2.services.memory.Memory;
import assign2.utils.CheckIfRollExists;
import assign2.utils.InputValidators;
import assign2.utils.ParseCourse;

import java.util.List;
import java.util.Scanner;

public class InteractiveInput {
    public static void run(Scanner scan, Memory memory) {
        String userFullName = null;
        try {
            System.out.print("Enter full name: ");
            userFullName = scan.nextLine();
            System.out.print("Enter age: ");
            int userAge = scan.nextInt();
            scan.nextLine();
            System.out.print("Enter address: ");
            String userAddress = scan.nextLine();
            System.out.print("Enter roll number: ");
            String userRollNo = scan.next();
            scan.nextLine();
            System.out.print("Enter 4 courses (A to F) separated by a comma. e.g \"A,B,C,D\": ");
            String userCourses = scan.nextLine().toUpperCase();
            add(memory, userFullName,userRollNo,userAddress,userAge,userCourses);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static void add(Memory memory,String name,String rollNum,String address,Integer age,String input) throws InputValidatorException, CourseInputException, RollNumberExistsException {
        InputValidators.validate(name,rollNum,address,age);
        CheckIfRollExists.check(memory,rollNum);
        List<Course> courses=ParseCourse.parse(input);

        User u=new User(name,age,address,rollNum,courses);
        memory.save(u);
        System.out.println("user saved successfully");
    }
}
