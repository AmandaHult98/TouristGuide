package com.example.touristguideapi.service;

import com.example.touristguideapi.model.TouristAttraction;
import com.example.touristguideapi.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TouristService {
    private TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public ArrayList<TouristAttraction> getTouristAttractions() {
        return repository.getAllAttractions();
    }

    public TouristAttraction findAttractionByName(String name) {
        TouristAttraction touristAttraction = repository.findAttractionByName(name);
        return touristAttraction;
    }

    public void addAttraction(TouristAttraction attraction) {
        repository.addAttraction(attraction);
    }

    public void updateAttraction(String name, TouristAttraction attraction) {
        repository.updateAttraction(name, attraction);
    }

    public void removeAttraction(String name) {
        repository.removeAttraction(name);
    }
}
