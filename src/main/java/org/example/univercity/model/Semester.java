package org.example.univercity.model;

public class Semester {
   private String name;
    public Semester(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return " در ترم :"+""+name;
    }
}
