package org.example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import org.example.univercity.model.Course;
import org.example.univercity.model.Student;
import org.example.univercity.model.Teacher;
import org.example.univercity.service.CoursesService;
import org.example.univercity.service.StudentService;
import org.example.univercity.service.TeacherService;
import java.util.Scanner;



public class Main {
    static TeacherService teacherService = new TeacherService();
    static StudentService studentService = new StudentService();
    static CoursesService coursesService = new CoursesService();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            int result = menu();
            showMenu(result);
        }

    }

    public static int menu() {
        System.out.println("به سامانه  ثبت دانشگاه خوش آمدید");
        System.out.println(" اگر استاد هستید گزینه 1 و در غیر اینصورت گزینه 2 را انتخاب کنید.");
        int result = sc.nextInt();

        return result;
    }


    public static void showMenu(int number) {

        switch (number) {

            case 1:
                System.out.println("استاد عزیز  میخواهید ثبت نام کنید یا لاگین نمائید");
                System.out.println("برای ثبت نام گزینه 1  برای لاگین گزینه 2 را انتخاب نمائید");
                int resultSignUpOrLogin = sc.nextInt();
                if (resultSignUpOrLogin == 1) {
                    signUpTeacher();
                } else {
                    System.out.println("آی دی خود را وارد نمائید:");
                    int id = sc.nextInt();
                    System.out.println("پسورد خود را وارد نمائید:");
                    String password = sc.next();
                    Teacher teacher = loginTeacher(id, password);
                    Course[] courses = null;
                    if (teacher != null) {
                        for (int i = 0; i < 3; i++) {
                            showAllCourses();
                            System.out.println("دوره مورد نظر رانتخاب کنید.");
                            String result = sc.next();
                            courses = courseChoice(result, teacher);

                        }
                        System.out.println("دوره های انتخاب شده");
                        for (int i = 0; i < 3; i++) {
                            if (courses[i] != null) {
                                System.out.println(courses[i].toString());
                            }

                        }

                    }

                }
                break;
            case 2:
                System.out.println("دانشجوی عزیز میخواهید ثبت نام کنید یا لاگین نمائید");
                System.out.println("برای ثبت نام گزینه 1  برای لاگین گزینه 2 را انتخاب نمائید");
                int resultSignUpOrLoginForStudent = sc.nextInt();
                if (resultSignUpOrLoginForStudent == 1) {
                    signUpStudent();
                } else {
                    System.out.println("کد دانشحویی خود را وارد نمائید:");
                    int codeStudent = sc.nextInt();
                    System.out.println("پسورد خود را وارد نمائید:");
                    String password = sc.next();
                    Student student = logingStudent(codeStudent, password);
                    System.out.println("نام استاد مورد نظر خود را وارد نمائید.");
                    Scanner scanner = new Scanner(System.in);
                    String teacherName = scanner.nextLine();
                    String nameTeacher = getNameTeacher(teacherName);
                    System.out.println("شما این استاد را انتخاب کرده اید:" + " " + nameTeacher);
                    System.out.println("هم اکنون میتوانید دوره های استاد انتخاب شده را ببینید");
                    Course[] course = getCourseForThisTeacher(nameTeacher);
                    Student newStudent = new Student();
                    newStudent.setCourses(course);
                    System.out.println("تمامی دوره ها برای دانشجوی عزیز ثبت گردید.");

                }


        }

    }


    public static void signUpTeacher() {

        System.out.println("استاد عزیز برای ثبت نام لطفا موارد خواسته شده را وارد نمائید:");
        System.out.println("کد استاد را وارد نمائید");
        int id = sc.nextInt();
        System.out.println("نام خود را وارد نمائید:");
        String firstName = sc.next();
        System.out.println("نام خانوادگی خود را وارد نمائید:");
        String lastName = sc.next();
        System.out.println("پسورد خود را وارد نمائید:");
        String password = sc.next();
        boolean result = teacherService.checkUserNameDuplicate(id);
        if (result) {
            System.out.println("استاد با این نام کاربری موجود می باشد لطفا مجددا تلاش فرمائید");
        } else {
            Teacher teacher = teacherService.signupT(id, firstName, lastName, password);
            System.out.println("عملیات ثیت نام با موفقیت انجام شد");
        }
    }

    public static Teacher loginTeacher(int id, String password) {

        Teacher teacher = teacherService.loginTeacher(id, password);
        if (teacher != null) {
            System.out.println("لاگین با موفقیت انجام شد و شما وارد سامانه شده اید.");
            System.out.println(teacher.getFirstName() + " " + teacher.getLastName());

        } else {
            System.out.println("آی دی و پسورد نادرست می باشد.");
            menu();
        }
        return teacher;
    }

    public static void showAllCourses() {
        Course[] courses = coursesService.getAllCourses();
        for (int index = 0; index < courses.length; index++) {
            System.out.println(courses[index].toString());
        }

    }


    public static Course[] courseChoice(String result, Teacher teacher) {
        Course[] courses = teacherService.courseChoice(result, teacher);
        return courses;
    }


    public static void signUpStudent() {
        System.out.println("دانشجوی گرامی عزیز برای ثبت نام لطفا موارد خواسته شده را وارد نمائید:");
        System.out.println("کد دانش آموز  را وارد نمائید");
        int codeStudent = sc.nextInt();
        System.out.println("نام خود را وارد نمائید:");
        String firstName = sc.next();
        System.out.println("نام خانوادگی خود را وارد نمائید:");
        String lastName = sc.next();
        System.out.println("پسورد خود را وارد نمائید:");
        String password = sc.next();
        boolean result = studentService.checkUserNameDuplicate(codeStudent);
        if (result) {
            System.out.println("دانشجو با این نام کاربری موجود می باشد لطفا مجددا تلاش قرمائید");
        } else if (result == false) {
            Student student = studentService.signupStudent(codeStudent, firstName, lastName, password);
            System.out.println("عملیات ثیت نام دانشجو با موفقیت انجام شد");
        }

    }

    public static Student logingStudent(int codeStudent, String password) {

        Student student = studentService.logingStudent(codeStudent, password);
        if (student != null) {
            System.out.println("لاگین با موفقیت انجام شد و شما وارد سامانه شده اید.");
            System.out.println(student.getFirstName() + " " + student.getLastName());

        } else {
            System.out.println("کد دانش آموز و پسورد نادرست می باشد.");
            menu();
        }
        return student;
    }

    public static String getNameTeacher(String name) {
        String teacher = teacherService.getNameTeacher(name);
        return teacher;

    }

    public static Course[] getCourseForThisTeacher(String teacherName) {
        Course[] course = teacherService.getCourseForThisTeacher(teacherName);
        for (int i = 0; i < course.length; i++) {
            if (course[i] != null) {
                System.out.println(course[i].toString());
            }
        }
        return course;
    }


}


