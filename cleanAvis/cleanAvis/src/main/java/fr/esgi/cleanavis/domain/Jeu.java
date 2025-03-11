package fr.esgi.cleanavis.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Jeu {

    private Long id;

    @NonNull
    private String nom;

    @NonNull
    @JsonManagedReference
    private Editeur editeur;

    private Genre genre;

    private Classification classification;

    private String description;

    private LocalDate dateDeSortie;

    @JsonManagedReference
    private List<Plateforme> plateformes;

    private String image;

    private float prix;
}
