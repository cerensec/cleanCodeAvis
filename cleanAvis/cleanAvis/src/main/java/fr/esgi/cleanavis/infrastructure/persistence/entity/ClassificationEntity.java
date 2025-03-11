package fr.esgi.cleanavis.infrastructure.persistence.entity;

import fr.esgi.cleanavis.domain.Classification;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Classification")
public class ClassificationEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String couleurRGB;
    @OneToMany(mappedBy = "classification")
    private List<JeuEntity> jeux;

    public Classification toDomain() {
        final Classification domain = new Classification();
        domain.setId(id);
        domain.setNom(nom);
        domain.setJeux(jeux != null ? jeux.stream().map(JeuEntity::toDomain).collect(Collectors.toList()) : null);
        return domain;
    }
}
