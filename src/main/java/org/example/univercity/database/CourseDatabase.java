package org.example.univercity.database;
import org.example.univercity.model.Course;
import org.example.univercity.model.Lesson;
import org.example.univercity.model.Semester;

public class CourseDatabase {

    static LessenDataBase lessenDataBase = new LessenDataBase();
    static SemesteryDataBase semesteryDataBase = new SemesteryDataBase();

    public static Course[] getAllCourses() {
        Lesson[] lessons = lessenDataBase.getAllLessons();
        Semester[] semesters = semesteryDataBase.getAllSemesters();
        Course[] courses = new Course[4];
        courses[0] = new Course("1", lessons[0], semesters[0]);
        courses[1] = new Course("2", lessons[1], semesters[1]);
        courses[2] = new Course("3", lessons[2], semesters[2]);
        courses[3] = new Course("4", lessons[3], semesters[3]);
        return courses;
    }


}
