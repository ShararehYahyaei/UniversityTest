package org.example.univercity.database;



public class DbTeacherTest {
    private static TeacherDatabace teacherDB = new TeacherDatabace();


    public static void main(String[] args) {
        when_newDuplicateUser_added_from_check_Duplicate_error_is_expected();
        when_newUser_added_Then_No_Error_Expected();
        when_newUser_added_And_List_Is_Empty_Then_No_Error_Expected();
        when_Id_PassWord_Is_True_User_Can_Login_Return_True_Expected();
    }
    public static void initValue() {
        teacherDB.signup(3, "hadi", "soleimany", "5");
        teacherDB.signup(4, "sharareh", "yahyaei", "45");
        teacherDB.signup(5, "sara", "salimi", "47");

    }

    public static void when_newDuplicateUser_added_from_check_Duplicate_error_is_expected() {
        initValue();
        boolean expectedValue = true;
        boolean result = teacherDB.checkUserDuplicate(4);
        if (expectedValue != result) {
            System.out.println("خطا");
        } else {
            System.out.println("موفق");
        }
    }
    public static void when_newUser_added_Then_No_Error_Expected() {
        initValue();
        boolean expectedValue = false;
        boolean result = teacherDB.checkUserDuplicate(56);
        if (expectedValue != result) {
            System.out.println("خطا");
        } else {
            System.out.println("موفق");
        }
    }
    public static void when_newUser_added_And_List_Is_Empty_Then_No_Error_Expected() {

        boolean expectedValue = false;
        boolean result = teacherDB.checkUserDuplicate(56);
        if (expectedValue != result) {
            System.out.println("خطا");
        } else {
            System.out.println("موفق");
        }
    }
    public static void when_Id_PassWord_Is_True_User_Can_Login_Return_True_Expected(){
        initValue();
        boolean expectedValue = true;
        //boolean result=teacherDB.loginTeacher(4,"45");
     //   if(result==expectedValue){
            System.out.println("موفق");
     //   }else{
            System.out.println("خطا");
        }


    }

//}





