package com.example.tarakhan.listview;

/**
 * Created by tArAkHaN on 13-04-2018.
 */

public class Modal {
    private String name, details;
    private int image;

    public Modal(String name, String details, int image) {
        this.name = name;
        this.details = details;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public int getImage() {
        return image;
    }
}
