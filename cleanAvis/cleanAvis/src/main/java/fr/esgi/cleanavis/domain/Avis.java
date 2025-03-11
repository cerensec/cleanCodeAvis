package fr.esgi.cleanavis.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Avis {

    private Long id;

    @NonNull
    private String description;

    @NonNull
    private Jeu jeu;

    @NonNull
    private Joueur joueur;

    private Float note;

    private LocalDateTime dateDEnvoi;

    private Moderateur moderateur;
}
