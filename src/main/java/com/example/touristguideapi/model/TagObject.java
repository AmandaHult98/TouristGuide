package com.example.touristguideapi.model;

import java.util.EnumSet;

public class TagObject {
    private int tag_id;
    private EnumSet<Tag> tag;


    public TagObject (int tag_id, EnumSet<Tag> tag) {
        this.tag_id = tag_id;
        this.tag = tag;
    }

    //Getters
    public int getTag_id() {
        return tag_id;
    }

    public EnumSet<Tag> getTag() {
        return tag;
    }

    //Setters
    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public void setTag(EnumSet<Tag> tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Tag id: " + tag_id + ", tags: " + tag;
    }
}
