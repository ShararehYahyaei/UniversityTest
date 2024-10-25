package org.example.univercity.database;

public class StudentDatabaseTest {
    private static StudentDb studentDB = new StudentDb();

    public static void main(String[] args) {
        when_newDuplicateUser_added_from_check_Duplicate_error_is_expected();
    }

    public static void initValue() {
        studentDB.signUpStudent(3, "hadi", "soleimany", "5");
        studentDB.signUpStudent(4, "sharareh", "yahyaei", "45");
        studentDB.signUpStudent(5, "sara", "salimi", "47");

    } public static void when_newDuplicateUser_added_from_check_Duplicate_error_is_expected() {
        initValue();
        boolean expectedValue = true;
        boolean result = studentDB.IsStudentExist(4);
        if (expectedValue == result) {
            System.out.println("موفق");

        } else {
            System.out.println("خطا");
        }
    }
    public static void when_newUser_added_Then_No_Error_Expected() {
        initValue();
        boolean expectedValue = false;
        boolean result = studentDB.IsStudentExist(56);
        if (expectedValue != result) {
            System.out.println("خطا");
        } else {
            System.out.println("موفق");
        }
    }


    public static void when_newStudent_added_And_List_Is_Empty_Then_No_Error_Expected() {

        boolean expectedValue1 = false;
        boolean result = studentDB.IsStudentExist(56);
        if (expectedValue1 != result) {
            System.out.println("خطا");
        } else {
            System.out.println("موفق");
        }
    }
}