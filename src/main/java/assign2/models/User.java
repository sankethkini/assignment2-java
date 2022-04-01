package assign2.models;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String name;
    private Integer age;
    private String address;
    private String rollNum;
    private List<Course> courses;

    public User(String name, Integer age, String address, String rollNum, List<Course> courses) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.rollNum = rollNum;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getRollNum() {
        return rollNum;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
