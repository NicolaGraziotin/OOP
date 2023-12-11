package it.unibo.composition;

import java.util.Arrays;

import it.unibo.composition.ExamRoom;

public class Exam {

    private static final int INITIAL_REGISTERED_STUDENTS = 0;

    private final int id;
    private final int maxStudents;
    private int registeredStudents;
    private final String courseName;
    private final Professor professor;
    private final ExamRoom room;
    private Student[] students;

    public Exam(int id, int maxStudents, String courseName, Professor professor, ExamRoom room) {
        this.id = id;
        this.maxStudents = maxStudents;
        this.registeredStudents = INITIAL_REGISTERED_STUDENTS;
        this.courseName = courseName;
        this.professor = professor;
        this.room = room;
        this.students = new Student[0];
    }

    private void expandArray() {
        this.students = Arrays.copyOf(this.students, students.length + 1);
    }

    public void registerStudent(Student student) {
        if (this.registeredStudents < this.maxStudents) {
            expandArray();
            this.students[this.registeredStudents++] = student;
        }
    }

    public String toString() {
        return "Exam ["
            + "id=" + this.id
            + ", max students=" + this.maxStudents
            + ", registered students=" + this.registeredStudents
            + ", course name=" + this.courseName
            + ", " + this.professor.toString()
            + ", " + this.room.toString()
            + ", " + Arrays.toString(this.students)
            + "]";
    }
}
