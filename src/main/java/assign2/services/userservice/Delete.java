package assign2.services.userservice;

import assign2.constants.DisplayConstants;
import assign2.models.User;
import assign2.services.memory.Memory;

import java.util.Scanner;

public class Delete {
    public static void run(Scanner sc, Memory memory){
        System.out.println(DisplayConstants.line);
        System.out.print("Enter roll number");
        String roll=sc.nextLine();
        User u=memory.delete(roll);
        if(u==null){
            System.out.println("no such user found");
            return;
        }
        System.out.println("user deleted successfully");
    }
}
