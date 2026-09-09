package com.example.touristguideapi.controller;

import com.example.touristguideapi.model.TouristAttraction;
import com.example.touristguideapi.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService service;


    public TouristController(TouristService touristService) {
        this.service = touristService;

    }

    // GET-endpoint, der henter alle turistattraktioner fra service layer.
    // Returnerer til klienten med status 200 (OK).
    @GetMapping()
    public ResponseEntity<ArrayList<TouristAttraction>> getToursitAttrctions() {
        ArrayList<TouristAttraction> attractions = service.getTouristAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }

    // GET-endpoint, der henter information om en specifik attraktion fra service layer.
    // Returnerer til klienten med status 200 (OK) hvis attraktionen findes.
    // Returnerer status 404 (NOT FOUND) hvis attraktionen ikke findes.
    @GetMapping("{name}")
    public ResponseEntity<TouristAttraction> getName(@PathVariable String name) {
        TouristAttraction attraction = service.findAttractionByName(name);
        if (attraction == null) {
            return new ResponseEntity<>(attraction, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(attraction, HttpStatus.OK);
        }
    }


    // POST-endpoint der tilføjer en attraktion (navn og beskrivelse) til attraktionslisten.
    // Kalder på service layer, som derefter kalder på repository layer.
    // Returnerer til klienten med status 201 (CREATED) når attraktionen blev oprettet.
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction attraction) {
        service.addAttraction(attraction);
        return ResponseEntity.status(201).body(attraction);
    }


    //POST-endpoint der ændrer på en eksisterende attraktion.
    // Kan ændre både navn og beskrivelse.
    // Kalder på service layer, som derefter kalder på repository layer.
    // Returnerer til klienten med status 200 (OK) når attraktionen blev ændret.
    // Returnerer status 500 (INTERNAL SERVER ERROR), hvis der opstår en fejl.
    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction attraction) {
        service.updateAttraction(attraction.getName(), attraction);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }


    //POST-endpoint der sletter på en eksisterende attraktion.
    // Kalder på service layer, som derefter kalder på repository layer.
    // Returnerer til klienten med status 200 (OK) når attraktionen blev slettet.
    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> removeAttraction(@PathVariable String name, @RequestBody TouristAttraction attraction) {
        service.removeAttraction(name);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }
}
