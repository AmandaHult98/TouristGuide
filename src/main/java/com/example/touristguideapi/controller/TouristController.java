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

    @GetMapping()
    public ResponseEntity<ArrayList<TouristAttraction>> getToursitAttrctions() {
        ArrayList<TouristAttraction> attractions = service.getTouristAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<TouristAttraction> getName(@PathVariable String name) {
        TouristAttraction attraction = service.findAttractionByName(name);
        if (attraction == null) {
            return new ResponseEntity<>(attraction, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(attraction, HttpStatus.OK);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction attraction) {
       service.addAttraction(attraction);
       return ResponseEntity.status(201).body(attraction);
    }

    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction attraction) {
        service.updateAttraction(attraction);
        if (attraction == null) {
            return new ResponseEntity<>(attraction, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(attraction, HttpStatus.OK);
        }
    }

    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> removeAttraction(@PathVariable String name, @RequestBody TouristAttraction attraction) {
        service.removeAttraction(attraction);
    }
}




}
