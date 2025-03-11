package fr.esgi.cleanavis.application.responseModels;

import fr.esgi.cleanavis.domain.Jeu;

import java.util.List;

public class ClassificationResponseModel {
    private Long id;
    private String nom;
    private String couleurRGB;
    private List<JeuResponseModel> jeux;

    public ClassificationResponseModel(
            Long id,
            String nom,
            String couleurRGB,
            List<JeuResponseModel> jeux
    ) {
        this.id = id;
        this.nom = nom;
        this.couleurRGB = couleurRGB;
        this.jeux = jeux;
    }
}
