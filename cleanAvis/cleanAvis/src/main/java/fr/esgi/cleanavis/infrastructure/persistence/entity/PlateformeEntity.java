package fr.esgi.cleanavis.infrastructure.persistence.entity;

import fr.esgi.cleanavis.domain.Plateforme;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Plateforme")
public class PlateformeEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private LocalDate dateDeSortie;
    @ManyToMany(mappedBy = "plateformes")
    private List<JeuEntity> jeux;

    public Plateforme toDomain() {
        final Plateforme domain = new Plateforme();
        domain.setId(id);
        domain.setNom(nom);
        domain.setDateDeSortie(dateDeSortie);
        domain.setJeux(jeux != null ? jeux.stream().map(JeuEntity::toDomain).collect(Collectors.toList()) : null);
        return domain;
    }
}
