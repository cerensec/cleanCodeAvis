package fr.esgi.cleanavis.application.gateway;

import fr.esgi.cleanavis.domain.Jeu;

import java.util.List;

public interface IJeuGateway {
    List<Jeu> recupererJeux();
    Jeu recupererJeuParId(Long id);
}
