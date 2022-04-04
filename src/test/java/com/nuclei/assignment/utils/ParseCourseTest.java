package com.nuclei.assignment.utils;

import com.nuclei.assignment.exceptions.CourseInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParseCourseTest {

  @Test
  @DisplayName("check if input is blank")
  public void testBlankInput() {

    Assertions.assertThrows(
        CourseInputException.class
        , () -> {
          ParseCourse.parse("");
        }
    );
  }

  @Test
  @DisplayName("check if input is not formatted correctly")
  public void testWrongFormat() {
    Assertions.assertThrows(
        CourseInputException.class
        , () -> {
          ParseCourse.parse("A,B.C,D");
        }
    );
  }

  @Test
  @DisplayName("check if course code is not available")
  public void testNotAvailable() {
    Assertions.assertThrows(
        CourseInputException.class
        , () -> {
          ParseCourse.parse("A,B,C,G");
        }
    );
  }

  @Test
  @DisplayName("check if number of course entered is not equal to max courses")
  public void testNotEqual() {
    Assertions.assertThrows(
        CourseInputException.class
        , () -> {
          ParseCourse.parse("A,B,F");
        }
    );
  }

  @Test
  @DisplayName("check if everything is correct")
  public void testCorrect() {
    Assertions.assertDoesNotThrow(
        () -> {
          ParseCourse.parse("A,B,F,D");
        }
    );
  }
}
