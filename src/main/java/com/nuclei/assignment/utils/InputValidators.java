package com.nuclei.assignment.utils;

import com.nuclei.assignment.exceptions.InputValidatorException;
import com.nuclei.assignment.services.storage.Storage;

public class InputValidators {
  /**
   * validate user inputs.
   *
   * @param name    - name of the user.
   * @param rollNum - roll number of the user.
   * @param address - address of the user.
   * @param age     - age of the user.
   */
  public static void validate(Storage memory, String name, String rollNum, String address,
                              Integer age)
      throws Exception {
    if (name.length() <= 1) {
      throw new InputValidatorException("name is blank");
    }
    if (age <= 0) {
      throw new InputValidatorException("age cannot be negative");
    }
    if (address.length() <= 1) {
      throw new InputValidatorException("address is blank");
    }
    if (rollNum.length() == 0) {
      throw new InputValidatorException("rollNumber is blank");
    }
    CheckIfRollExists.check(memory, rollNum);
  }
}
