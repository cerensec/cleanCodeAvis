package fr.esgi.cleanavis.application.responseModels;

import java.time.LocalDate;

public class JeuResponseModel {
    private Long id;
    private String nom;
    private String genre;
    private String classification;
    private String description;
    private LocalDate dateDeSortie;
    private String image;
    private float prix;

    public JeuResponseModel(
            Long id,
            String nom,
            String genre,
            String classification,
            String description,
            LocalDate dateDeSortie,
            String image,
            float prix
    ) {
        this.id = id;
        this.nom = nom;
        this.genre = genre;
        this.classification = classification;
        this.description = description;
        this.dateDeSortie = dateDeSortie;
        this.image = image;
        this.prix = prix;
    }

}
