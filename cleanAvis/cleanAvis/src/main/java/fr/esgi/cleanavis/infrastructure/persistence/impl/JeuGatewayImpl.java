package fr.esgi.cleanavis.infrastructure.persistence.impl;

import fr.esgi.cleanavis.application.gateway.IJeuGateway;
import fr.esgi.cleanavis.domain.Jeu;
import fr.esgi.cleanavis.infrastructure.persistence.entity.JeuEntity;
import fr.esgi.cleanavis.infrastructure.persistence.repository.JeuJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class JeuGatewayImpl implements IJeuGateway {
    @Autowired
    JeuJpaRepository repository;

    public JeuGatewayImpl() {
    }

    @Override
    public List<Jeu> recupererJeux() {
        return repository.findAll().stream().map(JeuEntity::toDomain).collect(Collectors.toList());
    }

    public Jeu recupererJeuParId(Long id) {
        return repository.findById(id)
                .map(JeuEntity::toDomain)
                .orElse(null);
    }
}
