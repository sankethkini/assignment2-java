package com.nuclei.assignment.utils;

import com.nuclei.assignment.services.storage.MemoryImpl;
import com.nuclei.assignment.services.storage.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddUserTest {
  Storage memory;

  @BeforeEach
  public void init() {
    memory = new MemoryImpl();
  }

  @Test
  @DisplayName("add user if all paramas are correct")
  public void addUserAllCorrect() {

    Assertions.assertDoesNotThrow(
        () -> {
          AddUser.add(memory, "some", "12s", "some address", 12, "A,B,C,D");
        }
    );

  }
}
