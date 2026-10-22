package com.example.touristguideapi.model;

import java.util.EnumSet;

// skal evt slettes

public class TagObject {
    private int tag_id;
    private String tag_name;


    public TagObject (int tag_id, String tag_name) {
        this.tag_id = tag_id;
        this.tag_name = tag_name;
    }

    //Getters
    public int getId() {
        return tag_id;
    }

    public String getName() {
        return tag_name;
    }

    //Setters
    public void setId(int tag_id) {
        this.tag_id = tag_id;
    }

    public void setName(String tag_name) {
        this.tag_name = tag_name;
    }

    @Override
    public String toString() {
        return "Tag id: " + tag_id + ", tags: " + tag_name;
    }
}
