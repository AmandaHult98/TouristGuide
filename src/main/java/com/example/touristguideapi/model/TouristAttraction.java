package com.example.touristguideapi.model;

import java.util.List;

public class TouristAttraction {
    private String name;
    private String description;
    private List<Tags> tags;
    private String city;

    public TouristAttraction() {

    }

    public TouristAttraction(String name, String description, List<Tags> tags, String city) {
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nDescription: " + description +
                "\nTags: " + tags +
                "\nCity: " + city;
    }
}
