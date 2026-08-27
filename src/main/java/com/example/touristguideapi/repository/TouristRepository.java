package com.example.touristguideapi.repository;

import com.example.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/*
Klassen skal desuden indeholde CRUD metoder, der arbejder på ovenstående ArrayList.

Vent evt. med den endelige metodesignatur for CRUD metoderne til I
har set beskrivelsen af Controller klassens endpoints nedenfor.
*/

@Repository
public class TouristRepository {
    private ArrayList<TouristAttraction> touristAttractions = new ArrayList<>();

    TouristAttraction tivoli = new TouristAttraction("Tivoli","Forlystelsespark i indre København");
    TouristAttraction castle = new TouristAttraction("Kronborg", "Slot i Helsingør, hvor Hamlet foregår.");
    TouristAttraction tower = new TouristAttraction("Rundetårn", "Astronomisk tårn fra Christian IVs tid.");

    public void addInitialAttractions(){
        touristAttractions.add(tivoli);
        touristAttractions.add(castle);
        touristAttractions.add(tower);
    }

    public void addAttraction(TouristAttraction attraction){
        touristAttractions.add(attraction);
    }

    public ArrayList<TouristAttraction> getAllAttractions(){
        return touristAttractions;
    }

    
}
