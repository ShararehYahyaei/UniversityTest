package org.example.univercity.model;

public class Student {
    private int codeStudent;
    private String firstName;
    private String lastName;
    private String password;
    private Course[] courses;

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public Student(int codeStudent, String firstName, String lastName, String password) {
        this.codeStudent = codeStudent;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public Student() {
    }

    public void setCodeStudent(int codeStudent) {
        this.codeStudent = codeStudent;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCodeStudent() {
        return codeStudent;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
