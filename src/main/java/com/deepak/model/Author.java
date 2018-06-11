package com.deepak.model;

/**
 * Created by deepakvalechha on 10/06/18.
 */
public class Author {

    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "com.deepak.model.Author{" + "name='" + name + '\'' + '}';
    }
}
