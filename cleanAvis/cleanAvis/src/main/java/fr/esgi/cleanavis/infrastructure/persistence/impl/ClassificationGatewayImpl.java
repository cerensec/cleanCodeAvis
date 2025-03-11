package fr.esgi.cleanavis.infrastructure.persistence.impl;

import fr.esgi.cleanavis.application.gateway.IClassificationGateway;
import fr.esgi.cleanavis.domain.Classification;
import fr.esgi.cleanavis.infrastructure.persistence.entity.ClassificationEntity;
import fr.esgi.cleanavis.infrastructure.persistence.repository.ClassificationJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ClassificationGatewayImpl implements IClassificationGateway {
    final ClassificationJpaRepository repository;

    public ClassificationGatewayImpl(ClassificationJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Classification> recupererClassifications() {
        return repository.findAll().stream().map(ClassificationEntity::toDomain).collect(Collectors.toList());
    }
}
