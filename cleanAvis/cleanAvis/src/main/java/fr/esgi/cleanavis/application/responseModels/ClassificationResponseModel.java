package fr.esgi.cleanavis.application.responseModels;

import fr.esgi.cleanavis.domain.Jeu;

import java.util.List;

public class ClassificationResponseModel {
    private Long id;
    private String nom;
    private String couleurRGB;
    private List<Jeu> jeux;
}
