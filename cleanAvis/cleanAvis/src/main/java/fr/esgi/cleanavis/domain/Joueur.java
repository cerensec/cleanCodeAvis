package fr.esgi.cleanavis.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class Joueur extends Utilisateur {

    private LocalDate dateDeNaissance;

    // Hypothèse de Nicolas : il ne sait pas comment initialiser la liste d'avis
    @Builder.Default
    private List<Avis> avis = new ArrayList<>();

    private Avatar avatar;
}
