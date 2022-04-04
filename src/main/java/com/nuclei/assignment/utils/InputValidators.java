package com.nuclei.assignment.utils;

import com.nuclei.assignment.exceptions.InputValidatorException;

public class InputValidators {
  public static void validate(String name, String rollNum, String address, Integer age)
      throws InputValidatorException {
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
  }
}
