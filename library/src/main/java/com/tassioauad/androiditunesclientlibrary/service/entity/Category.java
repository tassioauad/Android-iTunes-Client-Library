package com.tassioauad.androiditunesclientlibrary.service.entity;

/**
 * Created by Tássio Auad on 19/07/2014.
 */
public class Category {

    private String name;
    private String photoUrl;

    public Category() {
    }

    public Category(String name, String photoUrl) {
        this.name = name;
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
