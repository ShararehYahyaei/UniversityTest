package org.example.univercity.service;

import org.example.univercity.database.CourseDatabase;
import org.example.univercity.model.Course;

public class CoursesService {
static CourseDatabase courseDatabase = new CourseDatabase();
    public Course[] getAllCourses() {
     Course[]courses=  courseDatabase.getAllCourses();
     return courses;
    }



}
