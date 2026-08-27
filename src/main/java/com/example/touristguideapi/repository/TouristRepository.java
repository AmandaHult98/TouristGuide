package com.example.touristguideapi.repository;

import com.example.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
Klassen skal desuden indeholde CRUD metoder, der arbejder på ovenstående ArrayList.

Vent evt. med den endelige metodesignatur for CRUD metoderne til I
har set beskrivelsen af Controller klassens endpoints nedenfor.
*/

@Repository
public class TouristRepository {
    private ArrayList<TouristAttraction> touristAttractions = new ArrayList<>(
            List.of(
                    new TouristAttraction("Tivoli", "Forlystelsespark i indre København"),
                    new TouristAttraction("Kronborg", "Slot i Helsingør, hvor Hamlet foregår."),
                    new TouristAttraction("Rundetårn", "Astronomisk tårn fra Christian IVs tid.")
            )
    );

    public ArrayList<TouristAttraction> getAllAttractions() {
        return touristAttractions;
    }

    public TouristAttraction findAttractionByName(String name) {
        for (TouristAttraction attraction : touristAttractions) {
            if (Objects.equals(attraction.getName(), name)) {
                return attraction;
            }
        }
        return null;
    }

    public void addAttraction(TouristAttraction attraction) {
        touristAttractions.add(attraction);
    }

    public void removeAttraction(String name) {
        for (TouristAttraction attraction : touristAttractions) {
            if (Objects.equals(attraction.getName(), name)) {
                touristAttractions.remove(attraction);
            }
            else {
                System.out.println("No attraction with that name.");
            }
        }
    }

    public void updateAttractionName(String oldName, String newName) {
        for (TouristAttraction attraction : touristAttractions){
            if (Objects.equals(attraction.getName(), oldName)){
                attraction.setName(newName);
            }
            else {
                System.out.println("No attraction with that name.");
            }
        }
    }

    public void updateAttractionDescription(String name, String newDescription) {
        for (TouristAttraction attraction : touristAttractions){
            if (Objects.equals(attraction.getName(), name)){
                attraction.setDescription(newDescription);
            }
            else {
                System.out.println("No attraction with that name.");
            }
        }
    }

}
