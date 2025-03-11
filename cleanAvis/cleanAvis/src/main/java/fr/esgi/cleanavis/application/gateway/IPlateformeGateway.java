package fr.esgi.cleanavis.application.gateway;

import fr.esgi.cleanavis.domain.Plateforme;

import java.util.List;

/**
 * The interface Plateforme gateway.
 */
public interface IPlateformeGateway {
    /**
     * Recuperer plateformes list.
     *
     * @return the list
     */
    List<Plateforme> recupererPlateformes();
}
