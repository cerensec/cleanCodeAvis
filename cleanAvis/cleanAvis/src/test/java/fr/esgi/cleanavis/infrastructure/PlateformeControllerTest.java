package fr.esgi.cleanavis.infrastructure;

import fr.esgi.cleanavis.application.interactors.IPlateformeInputBoundary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.ModelAndView;

import static fr.esgi.cleanavis.utils.PlateformeResponseUtil.createMVResponse;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class PlateformeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    IPlateformeInputBoundary plateformeInputBoundary;

    @Test
    void testRecupererPlateformes() throws Exception {
        // Given
        final ModelAndView mv = createMVResponse();
        when(plateformeInputBoundary.recupererPlateformes()).thenReturn(mv);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/plateformes")
                .contentType(MediaType.APPLICATION_JSON);
        // Act & Assert
        mockMvc.perform(requestBuilder)
                .andExpect(view().name("plateformes"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("plateformes"))
                .andExpect(MockMvcResultMatchers.model().attribute("plateformes", mv.getModel().get("plateformes")))
                .andDo(MockMvcResultHandlers.print());
    }

}
