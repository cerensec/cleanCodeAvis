package fr.esgi.cleanavis.infrastructure.controller;

import fr.esgi.cleanavis.application.interactors.IJeuInputBoundary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class JeuController {
    private final IJeuInputBoundary inputBoundary;

    @GetMapping({"jeux"})
    public ModelAndView getJeux() {
        return inputBoundary.recupererJeux();
    }

    @GetMapping({"jeu/{id}"})
    public ModelAndView getJeu(@PathVariable Long id){
        return inputBoundary.recupererJeuParId(id);
    }
}
