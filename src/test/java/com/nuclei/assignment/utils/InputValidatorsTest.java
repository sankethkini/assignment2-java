package com.nuclei.assignment.utils;

import com.nuclei.assignment.exceptions.InputValidatorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorsTest {

  @Test
  @DisplayName("check if name is blank")
  public void testBlankName() {
    Assertions.assertThrows(
        InputValidatorException.class,
        () -> InputValidators.validate("", "12s", "some address", 12)
    );
  }

  @Test
  @DisplayName("check if age is negative")
  public void testNegativeAge() {
    Assertions.assertThrows(
        InputValidatorException.class,
        () -> InputValidators.validate("some", "12s", "some address", -12)
    );
  }

  @Test
  @DisplayName("check if address is blank")
  public void testBlankAddress() {
    Assertions.assertThrows(
        InputValidatorException.class,
        () -> InputValidators.validate("some", "12s", "", 12)
    );
  }

  @Test
  @DisplayName("check if roll number is blank")
  public void testBlankRoll() {
    Assertions.assertThrows(
        InputValidatorException.class,
        () -> InputValidators.validate("some", "", "some address", 12)
    );
  }
}
