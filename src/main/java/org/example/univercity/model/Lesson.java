package org.example.univercity.model;

public class Lesson {

    String title;

    public Lesson(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "درس :"+" "+title;

    }
}
