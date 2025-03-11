package fr.esgi.cleanavis.infrastructure.controller;

import fr.esgi.cleanavis.application.interactors.IClassificationInputBoudary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class ClassificationController {
    private final IClassificationInputBoudary inputBoundary;

    @GetMapping({"classifications"})
    public ModelAndView getClassifications() {
        return inputBoundary.recupererClassifications();
    }
}
