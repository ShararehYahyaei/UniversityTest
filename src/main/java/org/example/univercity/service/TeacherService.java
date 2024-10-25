package org.example.univercity.service;

import org.example.univercity.database.TeacherDatabace;
import org.example.univercity.model.Course;
import org.example.univercity.model.Teacher;

public class TeacherService {
    static Teacher teacher = new Teacher();
    static TeacherDatabace teacherDB = new TeacherDatabace();

    public Teacher signupT(int id, String firstName, String lastName, String password) {
        Teacher teacher = teacherDB.signup(id, firstName, lastName, password);
        return teacher;
    }

    public boolean checkUserNameDuplicate(int id) {
        boolean result = teacherDB.checkUserDuplicate(id);
        return result;
    }

    public Teacher loginTeacher(int id, String password) {
        Teacher teacher = teacherDB.loginTeacher(id, password);
        return teacher;

    }


    public Course[] courseChoice(String result, Teacher teacher) {

        Course[] courseChoisen = teacherDB.courseChoice(result, teacher);
        return courseChoisen;

    }

    public static Course[] courseTeacher() {
        Course[] course = teacher.getCourses();
        for (int i = 0; i < course.length; i++) {
            if (course[i] != null) {
                System.out.println(course[i]);
            }

        }
   return course;
    }

    public String getNameTeacher(String name) {
     String nameTeacher=   teacherDB.getNameTeacher(name);
     return nameTeacher;
    }

    public Course[] getCourseForThisTeacher(String teacherName) {
     Course[]course=teacherDB.getCourseForThisTeacher(teacherName);
     return course;
    }

}
