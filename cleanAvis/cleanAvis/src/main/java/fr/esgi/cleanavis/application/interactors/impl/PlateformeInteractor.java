package fr.esgi.cleanavis.application.interactors.impl;

import fr.esgi.cleanavis.application.gateway.IPlateformeGateway;
import fr.esgi.cleanavis.application.interactors.IPlateformeInputBoundary;
import fr.esgi.cleanavis.application.presenters.IPlateformePresenter;
import fr.esgi.cleanavis.application.responseModels.JeuResponseModel;
import fr.esgi.cleanavis.application.responseModels.PlateformeResponseModel;
import fr.esgi.cleanavis.domain.Jeu;
import fr.esgi.cleanavis.domain.Plateforme;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlateformeInteractor implements IPlateformeInputBoundary {

    private IPlateformeGateway gateway;
    private final IPlateformePresenter presenter;

    public PlateformeInteractor(IPlateformeGateway pGateway, IPlateformePresenter pPresenter) {
        this.gateway = pGateway;
        this.presenter = pPresenter;
    }

    @Override
    public ModelAndView recupererPlateformes() {

        final List<Plateforme> plateformes = gateway.recupererPlateformes();

        final List<PlateformeResponseModel> responseModels = plateformes.stream()
                .map(plateforme -> new PlateformeResponseModel(
                        plateforme.getId(),
                        plateforme.getNom(),
                        plateforme.getDateDeSortie(),
                        mapJeuxToJeuResponseModel(plateforme.getJeux())
                ))
                .collect(Collectors.toList());
        if(responseModels.isEmpty()) {
            return presenter.prepareFailView(responseModels);
        }
        return presenter.prepareSuccessView(responseModels);
    }

    @Override
    public List<PlateformeResponseModel> recupererPlateformesRest() {
        final List<Plateforme> plateformes = gateway.recupererPlateformes();

        final List<PlateformeResponseModel> responseModels =  plateformes.stream()
                .map(plateforme -> new PlateformeResponseModel(
                        plateforme.getId(),
                        plateforme.getNom(),
                        plateforme.getDateDeSortie(),
                        mapJeuxToJeuResponseModel(plateforme.getJeux())
                ))
                .collect(Collectors.toList());
        return presenter.prepareSuccesRestReesponse(responseModels);
    }

    private List<JeuResponseModel> mapJeuxToJeuResponseModel(List<Jeu> jeux){
        if (jeux != null) {
            return jeux.stream()
                    .map(jeu -> new JeuResponseModel(
                            jeu.getId(),
                            jeu.getNom(),
                            jeu.getGenre().getNom(),
                            jeu.getClassification().getNom(),
                            jeu.getDescription(),
                            jeu.getDateDeSortie(),
                            jeu.getImage(),
                            jeu.getPrix()
                    ))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
