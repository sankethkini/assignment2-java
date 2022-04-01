package assign2.utils;

import assign2.exceptions.RollNumberExistsException;
import assign2.models.User;
import assign2.services.memory.Memory;

import java.util.List;

public class CheckIfRollExists {
    public static void check(Memory memory, String rollNum) throws RollNumberExistsException {
        User u=memory.read(rollNum);
        if(u!=null){
            throw new RollNumberExistsException("roll already exists");
        }
    }
}
