package fr.esgi.cleanavis.infrastructure.persistence.entity;

import fr.esgi.cleanavis.domain.Jeu;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Jeu")
public class JeuEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String description;
    private float prix;
    private LocalDate dateDeSortie;
    private String image;

    @ManyToMany
    private List<PlateformeEntity> plateformes;

    @ManyToOne
    private GenreEntity genre;

    @ManyToOne
    private EditeurEntity editeur;

    @ManyToOne
    private ClassificationEntity classification;

    public Jeu toDomain() {
        return new Jeu(
                this.id,
                "Nom par défaut", // @NonNull exige un nom par défaut
                this.editeur != null ? this.editeur.toDomain() : null,
                this.genre != null ? this.genre.toDomain() : null,
                this.classification != null ? this.classification.toDomain() : null,
                this.description,
                this.dateDeSortie,
                plateformes != null ? plateformes.stream().map(PlateformeEntity::toDomain).toList() : null,
                this.image,
                this.prix
        );
    }


}
