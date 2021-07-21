package com.training.todo;

public class
Data {
    private int id;
    private String entry;

    public Data(String entry) {
        this.entry = entry;
    }

    public Data() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}
