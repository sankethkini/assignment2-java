package com.nuclei.assignment.utils;

import com.nuclei.assignment.exceptions.InputValidatorException;
import com.nuclei.assignment.services.storage.MemoryImpl;
import com.nuclei.assignment.services.storage.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorsTest {

  private Storage memory;

  @BeforeEach
  public void init() throws Exception {
    memory = new MemoryImpl(null);
  }

  @Test
  @DisplayName("check if name is blank")
  public void testBlankName() {
    Assertions.assertThrows(
        InputValidatorException.class,
        () -> InputValidators.validate(this.memory, "", "12s", "some address", 12)
    );
  }

  @Test
  @DisplayName("check if age is negative")
  public void testNegativeAge() {
    Assertions.assertThrows(
        InputValidatorException.class,
        () -> InputValidators.validate(this.memory, "some", "12s", "some address", -12)
    );
  }

  @Test
  @DisplayName("check if address is blank")
  public void testBlankAddress() {
    Assertions.assertThrows(
        InputValidatorException.class,
        () -> InputValidators.validate(this.memory, "some", "12s", "", 12)
    );
  }

  @Test
  @DisplayName("check if roll number is blank")
  public void testBlankRoll() {
    Assertions.assertThrows(
        InputValidatorException.class,
        () -> InputValidators.validate(this.memory, "some", "", "some address", 12)
    );
  }
}
