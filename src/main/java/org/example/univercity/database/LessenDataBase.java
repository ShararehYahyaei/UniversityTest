package org.example.univercity.database;

import org.example.univercity.model.Lesson;

public class LessenDataBase {

   public   Lesson[]  getAllLessons() {
       Lesson []lessons=new Lesson[4];
       lessons[0]=new Lesson("ریاضی");
       lessons[1]=new Lesson("علوم");
       lessons[2]=new Lesson("ادبیات");
       lessons[3]=new Lesson("حقوق");
       return lessons;
   }

}
