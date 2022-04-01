package assign2.services.storage;

import assign2.constants.CourseConstants;
import assign2.exceptions.CourseInputException;
import assign2.models.User;
import assign2.utils.ParseCourse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileStorageTest {

    FileStorage fileStorage=new FileStorage("usertest.ser");
    List<User> users=new ArrayList<>();

    @Test
    @DisplayName("check storing and reading from file")
    public void testIO(){
        users.add(new User("some",12,"some address","12s", CourseConstants.courses));
        Assertions.assertDoesNotThrow(
                ()->{
                    fileStorage.save(users);
                }
        );

        Assertions.assertDoesNotThrow(
                ()->{
                    List<User> ret=fileStorage.read();
                    if(ret==null || ret.size()!=users.size()){
                        throw new Exception("not equal");
                    }

                    for(int i=0;i<users.size();i++){
                        if(!users.get(i).getName().equals(ret.get(i).getName())){
                            throw new Exception("not equal");
                        }
                    }
                }
        );
    }
}
