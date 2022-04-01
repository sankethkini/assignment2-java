package assign2.services.storage;

import assign2.exceptions.FileReadException;
import assign2.exceptions.FileWriteException;
import assign2.models.User;

import java.util.List;

public interface Storage {
    void save(List<User> users) throws FileWriteException;
    List<User> read() throws FileReadException;
}
