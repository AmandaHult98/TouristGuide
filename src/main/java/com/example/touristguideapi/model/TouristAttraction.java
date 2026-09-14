package com.example.touristguideapi.model;

import java.util.EnumSet;

public class TouristAttraction {
    private String name;
    private String description;
    private EnumSet<Tag> tags;

    public TouristAttraction(String name, String description, EnumSet<Tag> tags) {
        this.name = name;
        this.description = description;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nDescription: " + description;
    }
}
