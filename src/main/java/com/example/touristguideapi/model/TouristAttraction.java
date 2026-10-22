package com.example.touristguideapi.model;

import java.util.ArrayList;

public class TouristAttraction {
    private int attraction_id;
    private String name;
    private String description;
    private int city_id;
    private ArrayList<String> tags;

    public TouristAttraction(int attraction_id, String name, String description, int city_id, ArrayList<String> tags) {
        this.attraction_id = attraction_id;
        this.name = name;
        this.description = description;
        this.city_id = city_id;
        this.tags = tags;
    }

//    public TouristAttraction(int id, String name, String description, String city_id, ArrayList<String> tags) {
//        this(id, name, description, Integer.parseInt(city_id), tags);
//    }

    public TouristAttraction(){}

    public int getAttraction_id() {
        return attraction_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCity_id() {
        return city_id;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setAttraction_id(int id) {
        this.attraction_id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nDescription: " + description +
                "\nTags: " + tags +
                "\nCity: " + city_id;
    }
}
