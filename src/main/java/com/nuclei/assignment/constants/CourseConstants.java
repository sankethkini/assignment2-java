package com.nuclei.assignment.constants;

import com.nuclei.assignment.enums.Courses;
import com.nuclei.assignment.models.Course;
import java.util.Arrays;
import java.util.List;

public class CourseConstants {
  public static final Integer MAX_COURSES = 4;
  public static final List<Course> COURSES = Arrays.asList(
      new Course(Courses.COURSE_A.getCode(), Courses.COURSE_A.getName()),
      new Course(Courses.COURSE_B.getCode(), Courses.COURSE_B.getName()),
      new Course(Courses.COURSE_C.getCode(), Courses.COURSE_C.getName()),
      new Course(Courses.COURSE_D.getCode(), Courses.COURSE_D.getName()),
      new Course(Courses.COURSE_E.getCode(), Courses.COURSE_E.getName()),
      new Course(Courses.COURSE_F.getCode(), Courses.COURSE_F.getName())
  );

}
