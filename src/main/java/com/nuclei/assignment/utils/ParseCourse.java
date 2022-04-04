package com.nuclei.assignment.utils;

import com.nuclei.assignment.constants.CourseConstants;
import com.nuclei.assignment.exceptions.CourseInputException;
import com.nuclei.assignment.models.Course;
import java.util.ArrayList;
import java.util.List;

public class ParseCourse {
  public static List<Course> parse(String input) throws CourseInputException {
    String[] cs = input.split(",");
    if (cs.length != CourseConstants.maxCourses) {
      throw new CourseInputException("selected courses not equal to max courses");
    }
    List<Course> courses = new ArrayList<>();
    for (String c : cs) {
      c = c.trim();
      boolean found = false;
      for (Course course : CourseConstants.courses) {
        String code = course.getCode();
        if (code.equals(c)) {
          courses.add(course);
          found = true;
          break;
        }
      }
      if (!found) {
        throw new CourseInputException("selected courses not found");
      }
    }
    return courses;
  }
}
