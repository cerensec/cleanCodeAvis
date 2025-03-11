package fr.esgi.cleanavis.utils;

import fr.esgi.cleanavis.application.responseModels.JeuResponseModel;
import fr.esgi.cleanavis.application.responseModels.PlateformeResponseModel;
import fr.esgi.cleanavis.domain.Jeu;
import fr.esgi.cleanavis.domain.Plateforme;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlateformeResponseUtil {

    private PlateformeResponseUtil() {};

    public static List<Plateforme> createMockPlateformes() {
        return List.of(
                new Plateforme(1L, "PlayStation", null, LocalDate.of(1994, 12, 3)),
                new Plateforme(2L, "Xbox", null, LocalDate.of(2001, 11, 15)),
                new Plateforme(3L, "PC", null, LocalDate.of(1980, 1, 1))
        );
    }

    public static ModelAndView createMVResponse() {
        List<Plateforme> plateformes = createMockPlateformes();
        List<PlateformeResponseModel> responseModels = plateformes.stream()
                .map(plateforme -> new PlateformeResponseModel(
                        plateforme.getId(),
                        plateforme.getNom(),
                        plateforme.getDateDeSortie(),
                        mapJeuxToJeuResponseModel(plateforme.getJeux())
                ))
                .collect(Collectors.toList());

        ModelAndView mv = new ModelAndView("plateformes");
        mv.addObject("plateformes", responseModels);
        return mv;
    }

    public static List<PlateformeResponseModel> createListPlateformeResponseModel() {
        List<Plateforme> plateformes = createMockPlateformes();
        return plateformes.stream()
                .map(plateforme -> new PlateformeResponseModel(
                        plateforme.getId(),
                        plateforme.getNom(),
                        plateforme.getDateDeSortie(),
                        mapJeuxToJeuResponseModel(plateforme.getJeux())
                ))
                .collect(Collectors.toList());
    }

    private static List<JeuResponseModel> mapJeuxToJeuResponseModel(List<Jeu> jeux){
        if (jeux != null) {
            return jeux.stream()
                    .map(jeu -> new JeuResponseModel(
                            jeu.getId(),
                            jeu.getNom(),
                            jeu.getGenre().getNom(),
                            jeu.getClassification().getNom(),
                            jeu.getDescription(),
                            jeu.getDateDeSortie(),
                            jeu.getImage(),
                            jeu.getPrix()
                    ))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
