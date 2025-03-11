package fr.esgi.cleanavis.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Plateforme {

    private Long id;

    @NonNull
    private String nom;

    @ToString.Exclude
    @JsonBackReference
    private List<Jeu> jeux;

    private LocalDate dateDeSortie;
}
