package com.example.touristguideapi.controller;

import com.example.touristguideapi.model.TouristAttraction;
import com.example.touristguideapi.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService service;

    public TouristController(TouristService touristService) {
        this.service = touristService;
    }

    @getMapping()
    public ResponseEntity<ArrayList<ToursitAttraction>> getToursitAttrctions() {
        ArrayList<TouristAttraction> attractions = service.getToursitAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }



}
