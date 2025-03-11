package fr.esgi.cleanavis.application.responseModels;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
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
