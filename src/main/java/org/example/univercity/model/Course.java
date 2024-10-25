
package org.example.univercity.model;

public class Course {
    String id;
    Lesson lesson;
    Semester semester;

    public Course(String id, Lesson lesson, Semester semester) {
        this.id = id;
        this.lesson = lesson;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return " مورد:"+ id + " " + lesson + " " + semester + " " + "ارائه شده است. ";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
