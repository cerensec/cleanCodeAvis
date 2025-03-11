package fr.esgi.cleanavis.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Editeur {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NonNull
    @NotBlank(message="Merci de préciser le nom de l'éditeur")
    @Size(min=2, message="Le nom de l'éditeur doit comporter au moins {min} caractères")
    private String nom;

    @JsonBackReference
    @ToString.Exclude
    private List<Jeu> jeux;
}
