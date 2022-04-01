package assign2.utils;

import assign2.models.User;

import java.util.Comparator;

public class Comparators {
    public static class AgeComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.getAge().compareTo(o2.getAge());
        }
    }
    public static class RollNumComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.getRollNum().compareToIgnoreCase(o2.getRollNum());
        }
    }
    public static class AddressComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.getAddress().compareToIgnoreCase(o2.getAddress());
        }
    }
    public static class NameComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    }
}
