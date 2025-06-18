package org.bestoftheyear.java.classes;

public class Song {

    int id;
    String title;

    public Song() {
    }

    public Song(String title, int id) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("id: %d, title: %s", getId(), getTitle());
    }

}
