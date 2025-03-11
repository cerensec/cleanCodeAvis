package fr.esgi.cleanavis.application.responseModels;

import fr.esgi.cleanavis.domain.Editeur;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JeuResponseModel {
    private Long id;
    private String nom;
    private String genre;
    private String classification;
    private String description;
    private LocalDate dateDeSortie;
    private String image;
    private float prix;
    // private Editeur editeur;

    public JeuResponseModel(
            Long id,
            String nom,
            String genre,
            String classification,
            String description,
            LocalDate dateDeSortie,
            String image,
            float prix/*,
            Editeur editeur */
    ) {
        this.id = id;
        this.nom = nom;
        this.genre = genre;
        this.classification = classification;
        this.description = description;
        this.dateDeSortie = dateDeSortie;
        this.image = image;
        this.prix = prix;
       // this.editeur = editeur;
    }

}
