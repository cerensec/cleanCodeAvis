package fr.esgi.cleanavis.application.gateway;

import fr.esgi.cleanavis.domain.Classification;

import java.util.List;

public interface IClassificationGateway {
    List<Classification> recupererClassifications();
}
