package org.example.univercity.service;


import org.example.univercity.database.StudentDb;
import org.example.univercity.model.Student;

public class StudentService {
    static StudentDb studentDb = new StudentDb();

    public Student signupStudent(int codeStudent, String firstName, String lastName, String password) {
        Student student=studentDb.signUpStudent(codeStudent,firstName,lastName,password);
        return student;
    }

    public boolean checkUserNameDuplicate(int  codeStudent ){
        boolean result=studentDb.IsStudentExist(codeStudent);
        return result;
    }


    public Student logingStudent(int codeStudent, String password) {
    Student student= studentDb.loginStudnet(codeStudent,password);
      return student;
    }
}
