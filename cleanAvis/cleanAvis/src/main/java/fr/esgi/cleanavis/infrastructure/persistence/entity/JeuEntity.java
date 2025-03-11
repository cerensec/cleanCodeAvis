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
        final Jeu domain = new Jeu();
        domain.setId(this.id);
        domain.setDescription(this.description);
        domain.setDateDeSortie(this.dateDeSortie);
        domain.setEditeur(this.editeur != null ? this.editeur.toDomain() : null);
        domain.setGenre(this.genre != null ? this.genre.toDomain() : null);
        domain.setPrix(this.prix);
        domain.setImage(this.image);
        domain.setClassification(this.classification != null ? this.classification.toDomain() : null);
        domain.setPlateformes(plateformes != null
                ? plateformes.stream().map(PlateformeEntity::toDomain).toList()
                : null);
        return domain;
     }

}
