package com.nuclei.assignment.utils;

import com.nuclei.assignment.models.User;
import java.util.Comparator;

public class Comparators {
  public static Comparator<User> AgeComparator = Comparator.comparing(User::getAge);

  public static Comparator<User> RollNumComparator = Comparator.comparing(User::getRollNum);

  public static Comparator<User> AddressComparator = Comparator.comparing(User::getAddress);

  public static Comparator<User> NameComparator = Comparator.comparing(User::getName);
}
