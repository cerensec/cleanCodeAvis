package fr.esgi.cleanavis.application.interactors.impl;

import fr.esgi.cleanavis.application.gateway.IClassificationGateway;
import fr.esgi.cleanavis.application.interactors.IClassificationInputBoudary;
import fr.esgi.cleanavis.application.presenters.IClassificationPresenter;
import fr.esgi.cleanavis.application.responseModels.ClassificationResponseModel;
import fr.esgi.cleanavis.application.responseModels.JeuResponseModel;
import fr.esgi.cleanavis.domain.Classification;
import fr.esgi.cleanavis.domain.Jeu;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

public class ClassificationInteractor implements IClassificationInputBoudary {
    private IClassificationGateway gateway;
    private final IClassificationPresenter presenter;

    public ClassificationInteractor(IClassificationGateway classificationGateway, IClassificationPresenter classificationPresenter){
        this.gateway = classificationGateway;
        this.presenter = classificationPresenter;
    }


    @Override
    public ModelAndView recupererClassifications() {
        final List<Classification> classifications = gateway.recupererClassifications();
        final List<ClassificationResponseModel> reponseModels = classifications.stream()
                .map(classification -> new ClassificationResponseModel(
                        classification.getId(),
                        classification.getNom(),
                        classification.getCouleurRGB(),
                        mapJeuxToJeuResponseModel(classification.getJeux())
                ))
                .collect(Collectors.toList());
        if(reponseModels.isEmpty()) {
            return presenter.prepareFailView(reponseModels);
        }
        return presenter.prepareSuccessView(reponseModels);
    }

    private List<JeuResponseModel> mapJeuxToJeuResponseModel(List<Jeu> jeux){
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
}
