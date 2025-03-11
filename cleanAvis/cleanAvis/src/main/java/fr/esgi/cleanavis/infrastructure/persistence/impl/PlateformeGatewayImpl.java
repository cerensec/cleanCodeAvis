package fr.esgi.cleanavis.infrastructure.persistence.impl;

import fr.esgi.cleanavis.application.gateway.IPlateformeGateway;
import fr.esgi.cleanavis.domain.Plateforme;
import fr.esgi.cleanavis.infrastructure.persistence.entity.PlateformeEntity;
import fr.esgi.cleanavis.infrastructure.persistence.repository.PlateformeJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PlateformeGatewayImpl implements IPlateformeGateway {

    final PlateformeJpaRepository repository;

    public PlateformeGatewayImpl(PlateformeJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Plateforme> recupererPlateformes() {
        return repository.findAll().stream().map(PlateformeEntity::toDomain).collect(Collectors.toList());
    }
}
