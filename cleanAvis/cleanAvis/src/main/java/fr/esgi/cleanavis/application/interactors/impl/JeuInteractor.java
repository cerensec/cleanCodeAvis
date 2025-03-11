package fr.esgi.cleanavis.application.interactors.impl;

import fr.esgi.cleanavis.application.gateway.IJeuGateway;
import fr.esgi.cleanavis.application.interactors.IJeuInputBoundary;
import fr.esgi.cleanavis.application.presenters.IJeuPresenter;
import fr.esgi.cleanavis.application.responseModels.JeuResponseModel;
import fr.esgi.cleanavis.domain.Jeu;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

public class JeuInteractor implements IJeuInputBoundary {
    private IJeuGateway gateway;
    private final IJeuPresenter presenter;

    public JeuInteractor(IJeuGateway jeuGateway, IJeuPresenter jeuPresenter) {
        this.gateway = jeuGateway;
        this.presenter = jeuPresenter;
    }

    @Override
    public ModelAndView recupererJeux() {
        final List<Jeu> jeux = gateway.recupererJeux();

        final List<JeuResponseModel> responseModels = jeux.stream()
                .map(jeu -> new JeuResponseModel(
                        jeu.getId(),
                        jeu.getNom(),
                        jeu.getGenre().getNom(),
                        jeu.getClassification().getNom(),
                        jeu.getDescription(),
                        jeu.getDateDeSortie(),
                        jeu.getImage(),
                        jeu.getPrix()
                        //,jeu.getPlateformes()
                ))
                .collect(Collectors.toList());

        if(responseModels.isEmpty()) {
            return presenter.prepareFailViewGetAll(responseModels);
        }
        return presenter.prepareSuccessViewGetAll(responseModels);
    }

    public ModelAndView recupererJeuParId(Long id) {
        final Jeu jeu = gateway.recupererJeuParId(id);
        final JeuResponseModel jeuReponseModel = new JeuResponseModel(
                jeu.getId(),
                jeu.getNom(),
                jeu.getGenre().getNom(),
                jeu.getClassification().getNom(),
                jeu.getDescription(),
                jeu.getDateDeSortie(),
                jeu.getImage(),
                jeu.getPrix()
                //,jeu.getPlateformes()
        );

        if(jeuReponseModel != null) {
            return presenter.prepareFailViewForOne(jeuReponseModel);
        }

        return presenter.prepareSuccessViewForOne(jeuReponseModel);
    }
}
