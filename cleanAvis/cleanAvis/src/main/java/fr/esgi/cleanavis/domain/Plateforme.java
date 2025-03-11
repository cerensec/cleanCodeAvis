package fr.esgi.cleanavis.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plateforme {

    private Long id;

    @NotNull(message = "Nom cannot be null")
    private String nom;

    @ToString.Exclude
    @JsonBackReference
    private List<Jeu> jeux;

    private LocalDate dateDeSortie;
}
