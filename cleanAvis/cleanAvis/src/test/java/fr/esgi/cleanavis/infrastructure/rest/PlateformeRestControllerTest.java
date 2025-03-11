package fr.esgi.cleanavis.infrastructure.rest;

import fr.esgi.cleanavis.application.interactors.IPlateformeInputBoundary;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static fr.esgi.cleanavis.utils.PlateformeResponseUtil.createListPlateformeResponseModel;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PlateformeRestControllerTest {
    @MockitoBean
    IPlateformeInputBoundary inputBoundary;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetPlateformes() throws Exception {
        // Arrange
        final List<PlateformeResponseModel> plateformes = createListPlateformeResponseModel();

        when(inputBoundary.recupererPlateformesRest()).thenReturn(plateformes);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/plateformes/getAll");

        // Act and Assert
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3)) // Assert the content of the response
                .andDo(MockMvcResultHandlers.print()) // Print the response for debugging (optional)
                .andReturn();
        Mockito.verify(inputBoundary, Mockito.times(1)).recupererPlateformesRest();
    }
}
