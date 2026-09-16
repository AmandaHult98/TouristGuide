package com.example.touristguideapi.model;

import java.util.EnumSet;

public class TouristAttraction {
    private String name;
    private String description;
    private String city;
    private EnumSet<Tag> tags;
    private List<Tags> tags;
    private String city;

    public TouristAttraction() {

    public TouristAttraction(String name, String description, String city, EnumSet<Tag> tags) {
    }

    public TouristAttraction(String name, String description, List<Tags> tags, String city) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public EnumSet<Tag> getTags() {
        return tags;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(EnumSet<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nDescription: " + description +
                "\nTags: " + tags +
                "\nCity: " + city;
    }
}
