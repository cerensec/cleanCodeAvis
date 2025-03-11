package fr.esgi.cleanavis.infrastructure.persistence.entity;

import fr.esgi.cleanavis.domain.Genre;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Genre")
public class GenreEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    @OneToMany(mappedBy = "genre")
    private List<JeuEntity> jeux;

    public Genre toDomain() {
        final Genre domain = new Genre();
        domain.setId(id);
        domain.setNom(nom);
        domain.setJeux(jeux != null ? jeux.stream().map(JeuEntity::toDomain).collect(Collectors.toList()) : null);

        return domain;
    }
}
