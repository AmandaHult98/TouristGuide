package com.example.touristguideapi.repository;

import com.example.touristguideapi.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
/*
Klassen skal desuden indeholde CRUD metoder, der arbejder på ovenstående ArrayList.

Vent evt. med den endelige metodesignatur for CRUD metoderne til I
har set beskrivelsen af Controller klassens endpoints nedenfor.
*/

@Repository
public class TouristRepository {

    private final JdbcTemplate jdbcTemplate;

    public TouristRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public TouristAttraction findAttractionById(int id) {
        String sql = "SELECT * FROM tourist_attraction WHERE attraction_id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new TouristAttractionRowMapper(),
                id
        );


    }

}