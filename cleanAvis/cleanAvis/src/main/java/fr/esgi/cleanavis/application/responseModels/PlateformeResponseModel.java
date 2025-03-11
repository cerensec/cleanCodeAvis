package fr.esgi.cleanavis.application.responseModels;

import java.time.LocalDate;
import java.util.List;

public class PlateformeResponseModel {
    private Long id;
    private String nom;
    private LocalDate dateDeSortie;
    private List<JeuResponseModel> jeux;

    public PlateformeResponseModel(Long id, String nom, LocalDate dateDeSortie, List<JeuResponseModel> jeux) {
        this.id = id;
        this.nom = nom;
        this.dateDeSortie = dateDeSortie;
        this.jeux = jeux;
    }
}
