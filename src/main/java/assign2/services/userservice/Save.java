package assign2.services.userservice;

import assign2.enums.Field;
import assign2.enums.Order;
import assign2.models.User;
import assign2.services.memory.Memory;
import assign2.services.storage.Storage;
import java.util.List;


public class Save {
    public static void run(Storage storage, Memory memory)  {
        try{
            List<User> users=memory.readAll(Field.NAME, Order.ASC);
            if(users==null)return;
            storage.save(users);
            System.out.println("users saved successfully");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
