package fr.esgi.cleanavis.infrastructure.controller;

import fr.esgi.cleanavis.application.interactors.IPlateformeInputBoundary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class PlateformeController {

    private final IPlateformeInputBoundary inputBoundary;

    @GetMapping({"plateformes"})
    public ModelAndView getPlateformes() {
        return inputBoundary.recupererPlateformes();
    }
}
