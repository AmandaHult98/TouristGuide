package com.example.touristguideapi.controller;

import com.example.touristguideapi.model.Tag;
import com.example.touristguideapi.model.TouristAttraction;
import com.example.touristguideapi.service.TouristService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.EnumSet;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TouristController.class)
public class TouristControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TouristService service;

    @Test
    void shouldGetAttractionTags() throws Exception {
        TouristAttraction attraction = new TouristAttraction("Tivoli", "Forlystelsespark i indre København",
                "København", EnumSet.of(Tag.AMUSEMENT_PARK, Tag.KID_FRIENDLY)
        );

        when(service.findAttractionByName("Tivoli"))
                .thenReturn(attraction);

        mockMvc.perform(get("/attractions/{name}/tags", "Tivoli"))
                .andExpect(status().isOk())
                .andExpect(view().name("tags"))
                .andExpect(model().attributeExists("taglist"))
                .andExpect(model().attribute("attraction", attraction));
    }

}
