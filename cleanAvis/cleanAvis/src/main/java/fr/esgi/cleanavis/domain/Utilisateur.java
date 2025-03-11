package fr.esgi.cleanavis.domain;


import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public abstract class Utilisateur {

    protected Long id;

    @NonNull
    protected String pseudo;

    @NonNull
    protected String motDePasse;

    @NonNull
    protected String email;
}
