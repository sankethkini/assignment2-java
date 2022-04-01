package assign2.services.userservice;

import assign2.constants.DisplayConstants;
import assign2.enums.Field;
import assign2.enums.Order;
import assign2.models.User;
import assign2.services.memory.Memory;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;
import java.util.Scanner;

public class Display {
    public static void run(Scanner sc, Memory memory){
       System.out.println(DisplayConstants.line);
       System.out.println(
               "Enter the field by which you want to sort\n"+
               "1. Name\n"+
               "2. Address\n"+
               "3. Roll number\n"+
               "4. Age"
       );
       int op=sc.nextInt();
       Field field;
       Order order;
       switch (op){
           case 1:
               field=Field.NAME;
           case 2:
               field=Field.ADDRESS;
           case 3:
               field=Field.ROLL;
           case 4:
               field=Field.AGE;
           default:
               field=Field.NAME;
       }
       System.out.println(
               "Enter the order\n"+
               "1. ascending\n"+
               "2. descending"
       );
       op=sc.nextInt();
       if(op==1){
           order=Order.ASC;
       } else {
           order=Order.DESC;
       }
       List<User> users=memory.readAll(field,order);
       System.out.println(DisplayConstants.line);
       for(User u:users){
           System.out.println(
                   "Name: "+u.getName()+
                   " RollNum: "+u.getRollNum()+
                   " Address: "+u.getAddress()+
                   " Age: " +u.getAge()
           );
       }
    }
}
