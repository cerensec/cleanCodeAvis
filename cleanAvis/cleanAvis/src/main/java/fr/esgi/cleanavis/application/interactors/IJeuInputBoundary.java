package fr.esgi.cleanavis.application.interactors;

import org.springframework.web.servlet.ModelAndView;

public interface IJeuInputBoundary {
    ModelAndView recupererJeux();
    ModelAndView recupererJeuParId(Long id);
}
