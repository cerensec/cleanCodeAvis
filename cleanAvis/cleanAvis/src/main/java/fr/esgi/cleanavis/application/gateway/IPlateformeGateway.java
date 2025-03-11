package fr.esgi.cleanavis.application.gateway;

import fr.esgi.cleanavis.domain.Plateforme;

import java.util.List;

public interface IPlateformeGateway {
    List<Plateforme> recupererPlateformes();
}
