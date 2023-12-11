package it.unibo.composition;

import java.util.Arrays;

public class Professor implements User {

    private final int id;
    private final String name;
    private final String surname;
    private final String password;
    private String[] courses;
    
    public Professor(int id, String name, String surname, String password, String[] courses) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.courses = Arrays.copyOf(courses, courses.length);
    }

    public String getUsername() {
        return this.name + this.surname;
    }

    public String getPassword() {
        return this.password;
    }

    public String getDescription() {
        return this.toString();
    }

    public String toString() {
        return "Professor ["
            + "name=" + this.name
            + ", surname=" + this.surname
            + ", id=" + this.id
            + "]";
    }

    public void replaceCourse(final String course, final int index) {
        this.courses[index] = course;
    }

    public void replaceAllCourses(String[] courses) {
        this.courses = Arrays.copyOf(courses, courses.length);
    }
}
