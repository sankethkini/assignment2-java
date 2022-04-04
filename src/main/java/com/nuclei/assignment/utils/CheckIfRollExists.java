package assign2.utils;

import assign2.exceptions.RollNumberExistsException;
import assign2.models.User;
import assign2.services.storage.Storage;
import java.util.Objects;

public class CheckIfRollExists {
  public static void check(Storage memory, String rollNum) throws RollNumberExistsException {
    User u = memory.read(rollNum);
    if (Objects.nonNull(u)) {
      throw new RollNumberExistsException("roll already exists");
    }
  }
}
