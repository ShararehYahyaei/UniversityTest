package org.example.univercity.database;


import org.example.univercity.model.Course;
import org.example.univercity.model.Teacher;

import java.awt.*;

public class TeacherDatabace {

    static CourseDatabase courseDatabase = new CourseDatabase();
    Teacher[] teachers = new Teacher[10];

    public Teacher signup(int id, String firstName, String lastName, String password) {
        Teacher teacher = new Teacher(id, firstName, lastName, password);
        for (int index = 0; index < teachers.length; index++) {
            if (teachers[index] == null) {
                teachers[index] = teacher;
                return teacher;
            }

        }
        return null;

    }

    public boolean checkUserDuplicate(int id) {

        for (int index = 0; index < teachers.length; index++) {
            if (teachers[index] != null) {
                if (teachers[index].getId() == id) {
                    return true;
                }
            }

        }
        return false;
    }

    public Teacher loginTeacher(int id, String password) {

        for (int index = 0; index < teachers.length; index++) {
            if (teachers[index] != null) {
                if (teachers[index].getId() == id && teachers[index].getPassword().equals(password)) {
                    return teachers[index];
                }
            }

        }

        return null;
    }

    public Course[] courseChoice(String result, Teacher teacher) {
        Course[] courses = courseDatabase.getAllCourses();
        Course[] teacherCourses = teacher.getCourses();
        int counter = 0; // شمارنده برای مدیریت اضافه‌کردن دوره‌ها

        // پیدا کردن موقعیت اولین جای خالی در دوره‌های استاد
        for (int i = 0; i < teacherCourses.length; i++) {
            if (teacherCourses[i] == null) {
                counter = i; // اولین جای خالی را پیدا کنید
                break;
            }
        }


        for (Course course : courses) {
            if (course != null && course.getId().equals(result)) {
                if (counter < teacherCourses.length) {
                    teacherCourses[counter] = course;
                    counter++;
                } else {
                    System.out.println("ظرفیت انتخاب دوره‌های استاد پر شده است.");
                    break;
                }
            }
        }

        teacher.setCourses(teacherCourses);
        return teacher.getCourses();
    }


    public String getNameTeacher(String firstName) {

        for (int index = 0; index < teachers.length; index++) {
            if(teachers[index] != null) {
                if(teachers[index].getFirstName().equals(firstName)) {
                    return teachers[index].getFirstName();
                }
            }
        }
        return null;

    }

    public Course[] getCourseForThisTeacher(String teacherName) {

        for(int i=0;i<teachers.length;i++) {
            if(teachers[i] != null) {
                if(teachers[i].getFirstName().equals(teacherName)) {
                    return teachers[i].getCourses();
                }
            }
        }
        return null;

    }
}