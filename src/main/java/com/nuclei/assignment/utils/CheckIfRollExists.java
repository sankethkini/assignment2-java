package com.nuclei.assignment.utils;

import com.nuclei.assignment.exceptions.RollNumberExistsException;
import com.nuclei.assignment.models.User;
import com.nuclei.assignment.services.storage.Storage;
import java.util.Objects;

public class CheckIfRollExists {
  /**
   * check if roll number already exists.
   *
   * @param memory  - memory implementation.
   * @param rollNum - roll number of the user.
   */
  public static void check(Storage memory, String rollNum) throws RollNumberExistsException {
    User u = memory.read(rollNum);
    if (Objects.nonNull(u)) {
      throw new RollNumberExistsException("roll already exists");
    }
  }
}
