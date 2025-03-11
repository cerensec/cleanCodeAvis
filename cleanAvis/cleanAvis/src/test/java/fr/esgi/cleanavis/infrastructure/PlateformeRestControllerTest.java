package fr.esgi.cleanavis.infrastructure;

import fr.esgi.cleanavis.application.interactors.impl.PlateformeInteractor;
import fr.esgi.cleanavis.application.responseModels.PlateformeResponseModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PlateformeRestControllerTest {
    @MockitoBean
    PlateformeInteractor plateformeInteractor;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetPlateformes() throws Exception {
        // Arrange
        final List<PlateformeResponseModel> plateformes = new ArrayList<>();
        final PlateformeResponseModel plateforme1 = new PlateformeResponseModel(1L, "PlayStation", LocalDate.of(1994, 12, 3), null);
        final PlateformeResponseModel plateforme2 = new PlateformeResponseModel(2L, "Xbox", LocalDate.of(2001, 11, 15), null);
        final PlateformeResponseModel plateforme3 = new PlateformeResponseModel(3L, "PC", LocalDate.of(1980, 1, 1), null);
        plateformes.add(plateforme1);
        plateformes.add(plateforme2);
        plateformes.add(plateforme3);


        when(plateformeInteractor.recupererPlateformesRest()).thenReturn(plateformes);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/plateformes/getAll");

        // Act and Assert
        Mockito.verify(plateformeInteractor, Mockito.times(1)).recupererPlateformesRest();
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("["
                        + "{\"id\":1,\"nom\":\"PlayStation\",\"dateDeSortie\":\"1994-12-03\"},"
                        + "{\"id\":2,\"nom\":\"Xbox\",\"dateDeSortie\":\"2001-11-15\"},"
                        + "{\"id\":3,\"nom\":\"PC\",\"dateDeSortie\":\"1980-01-01\"}]")) // Assert the content of the response
                .andDo(MockMvcResultHandlers.print()) // Print the response for debugging (optional)
                .andReturn();
    }
}
