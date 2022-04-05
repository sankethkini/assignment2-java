package com.nuclei.assignment.utils;

import java.io.File;

public class CheckEmptyFile {
  /**
   * check if file is empty.
   *
   * @param path - path of the file (relative to classpath).
   */
  public static boolean read(String path) {
    File file = new File(path);
    return file == null || file.length() == 0;
  }
}
