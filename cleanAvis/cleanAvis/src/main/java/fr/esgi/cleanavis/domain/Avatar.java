package fr.esgi.cleanavis.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Avatar {
    private Long id;

    private String nom;

    private Joueur joueur;
}
