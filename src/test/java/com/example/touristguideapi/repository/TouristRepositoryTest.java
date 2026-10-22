//Integrationstest af h2databasen
package com.example.touristguideapi.repository;

import com.example.touristguideapi.model.City;
import com.example.touristguideapi.model.TouristAttraction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "classpath:h2init.sql", executionPhase = BEFORE_TEST_METHOD)
class TouristRepositoryTest {

    @Autowired
    private TouristRepository repo;

    /*@Test
    void findAttractionById() {
        TouristAttraction attraction = repo.findAttractionById(1);

        assertThat(attraction).isNotNull();
        assertThat(attraction.getName()).isEqualTo("Kronborg");

    }*/

    @Test
    void getCities() {
        List<City> all = repo.getCities();

        assertThat(all).isNotNull();
        assertThat(all.size()).isEqualTo(2);
        assertThat(all.get(0).getCity_name()).isEqualTo("København");
        assertThat(all.get(1).getCity_name()).isEqualTo("Helsingør");

    }

    @Test
    void getAllAttractions() {
        List<TouristAttraction> allAttractions = repo.getAllAttractions();

        assertThat(allAttractions).isNotNull();
        assertThat(allAttractions.size()).isEqualTo(2);
        assertThat(allAttractions.get(0).getName()).isEqualTo("Tivoli");
        assertThat(allAttractions.get(1).getName()).isEqualTo("Kronborg");

    }

    @Test
    void addAttraction() {
    }

    @Test
    void removeAttraction() {
    }

    @Test
    void updateAttraction() {
    }
}