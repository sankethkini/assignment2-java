package com.nuclei.assignment.constants;

import com.nuclei.assignment.models.Course;
import java.util.Arrays;
import java.util.List;

public class CourseConstants {
  public static final Integer maxCourses = 4;
  public static final List<Course> courses = Arrays.asList(
      new Course("A", "some A"),
      new Course("B", "some B"),
      new Course("C", "some C"),
      new Course("D", "some D"),
      new Course("E", "some E"),
      new Course("F", "some F")
  );

}
