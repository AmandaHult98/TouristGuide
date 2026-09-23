package com.example.touristguideapi.controller;

import com.example.touristguideapi.model.Tag;
import com.example.touristguideapi.model.TouristAttraction;
import com.example.touristguideapi.service.TouristService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@WebMvcTest(TouristController.class)
class TouristControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //En stand-in for vores service-klasse
    @MockitoBean
    private TouristService touristService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //Her skal der testes at en GET request til /attractions endpointet returnerer en 200 OK status
    //og view navnet attractionList.
    @Test
    void shouldGetToursitAttrctions() throws Exception {
        mockMvc.perform(get("/attractions"))
                .andExpect(status().isOk())
                .andExpect(view().name("attractionList"));
    }

    @Test
    void getName() throws Exception{
        mockMvc.perform(get("/attractions/Tivoli"))
                .andExpect(status().isOk())
                .andExpect(view().name("attractionDetails"));
    }

    //Her skal der testes at en GET request til /add-attraction endpointet returnerer en
    // 200 OK status og view navnet add-attraction.
    @Test
    void shouldSubmitAttraction() throws Exception {
        mockMvc.perform(get("/attractions/add-attraction"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-attraction"));

    }

    //Her skal der testes en form submission via en POST request med parametere til /save endpointet.
    //Konfigurer den mockede TouristService til at returnere et TouristAttraction objekt,
    // når metoden addAttraction() kaldes med et vilkårligt TouristAttraction-objekt som argument (any(TouristAttraction.class))
    @Test
    void shouldAddAttraction() throws Exception {
        //Default sæt data, som vi kan teste.
        TouristAttraction touristAttraction = new TouristAttraction("Den lille havfrue", "Figur fra H.C.Andersens eventyr.", "København", EnumSet.of(Tag.ART));
        when(touristService.addAttraction(any(TouristAttraction.class))).thenReturn(touristAttraction); //Her definerer vi adfærden

        //Simuler en POST request til /save endpointet med de nødvendige parametre:
        mockMvc.perform(post("/attractions/save")
                .param("name", "Den lille havfrue")
                .param("description", "Figur fra H.C.Andersens eventyr.")
                .param("city", "København")
                //.param("tags", EnumSet.of(Tag.ART))
                .param("tags", "ART"))
                .andExpect(status().isOk())
                .andExpect(view().name("/successful"));

        //Dernæste vil man gerne verificere at servicemetoden bliver kaldt med de forventede argumenter.
        //Service objeketet er mocket med @MockitoBean og derfor den "rigtige" service metode bliver ikke udført,
        // men returneres værdien angivet i when(...).thenReturn(...) konfigurationen.

        //Mockitos verify() funktion bruges til at verificere at service metoden addAttraction() bliver kaldt og
        // med det forventede touristAttraction argument.

        //Testmetoden vil dog fejle her fordi touristAttraction objektet i when(...).thenReturn(...) og i verify(...) er to
        // forskellige objekter og selvom equals() og hashCode() i TouristAttraction er overskrevet (overridden) til at
        // sammenligne objekternes indhold dvs. attributterne, så vil Mockito ikke kunne matche dem i dette tilfælde
        // fordi touristAttraction attributten orderId er et random genereret UUID allokeret ved objektets oprettelse.

        //For at løse dette, kan ArgumentCaptor bruges til at fange det faktiske TouristAttraction objekt,
        // der bliver sendt til addAttraction() metoden, og derefter verificere dets attributter.

        ArgumentCaptor<TouristAttraction> captor = ArgumentCaptor.forClass(TouristAttraction.class);
        verify(touristService).addAttraction(captor.capture());

        TouristAttraction captured = captor.getValue();
        assertEquals("Den lille havfrue", captured.getName());
        assertEquals("Figur fra H.C.Andersens eventyr.", captured.getDescription());
        assertEquals("København", captured.getCity());
        assertEquals(EnumSet.of(Tag.ART), captured.getTags());
    }


    @Test
    void shouldEditAttraction() throws Exception{
        mockMvc.perform(get("/attractions/Tivoli/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("editAttraction"));
    }

    @Test
    void updateAttraction() {
    }

    @Test
    void removeAttraction() {
    }

    @Test
    void shouldGetAttractionTags() throws Exception {
        mockMvc.perform(get("/attractions/Tivoli/tags"))
                .andExpect(status().isOk())
                .andExpect(view().name("tags"));
    }
}