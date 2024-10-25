package org.example.univercity.database;

import org.example.univercity.model.Student;

public class StudentDb {
    Student[] students = new Student[10];


    public Student signUpStudent(int codeStudent, String firstName, String lastName, String password) {
        Student student = new Student(codeStudent, firstName, lastName, password);
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return student;
            }

        }
        return null;

    }

    public boolean IsStudentExist(int codeStudent) {
        for (int index = 0; index < students.length; index++) {
            if (students[index] != null) {
                System.out.println(students[index].getCodeStudent());
                if (students[index].getCodeStudent() == codeStudent) {
                    return true;
                }
            }

        }
        return false;
    }

    public Student loginStudnet(int codeStudent, String password) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getCodeStudent() == codeStudent && students[i].getPassword().equals(password)) {
                return students[i];
            }
        }

        return null;
    }
}
