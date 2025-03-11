package fr.esgi.cleanavis.infrastructure.persistence.entity;

import fr.esgi.cleanavis.domain.Editeur;
import fr.esgi.cleanavis.domain.Jeu;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Editeur")
public class EditeurEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    @OneToMany(mappedBy = "editeur")
    private List<JeuEntity> jeux;

    public Editeur toDomain() {
        final Editeur domain = new Editeur();
        domain.setId(id);
        domain.setNom(nom);
        domain.setJeux(jeux != null ? jeux.stream().map(JeuEntity::toDomain).collect(Collectors.toList()) : null);
        return domain;
    }
}
