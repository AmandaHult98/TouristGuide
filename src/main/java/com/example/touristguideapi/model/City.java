package com.example.touristguideapi.model;

public class City {
    private int city_id;
    private String city_name;

    public City(int city_id, String city_name) {
        this.city_id = city_id;
        this.city_name = city_name;
    }

    public int getId() {
        return city_id;
    }

    public String getName() {
        return city_name;
    }

    public void setId(int city_id) {
        this.city_id =city_id;
    }

    public void setName(String name) {
        this.city_name = city_name;
    }

    @Override
    public String toString() {
        return city_name;
    }
}
