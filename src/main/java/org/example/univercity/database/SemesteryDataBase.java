package org.example.univercity.database;

import org.example.univercity.model.Semester;

public class SemesteryDataBase {

    public  Semester[]  getAllSemesters(){
        Semester[] semesters=new Semester[4];
        semesters[0]=new Semester("مهر");
        semesters[1]=new Semester("آبان");
        semesters[2]=new Semester("آذر");
        semesters[3]=new Semester("فروردین");
        return semesters;
    }

}
