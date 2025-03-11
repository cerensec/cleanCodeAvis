package fr.esgi.cleanavis.infrastructure.config;

import fr.esgi.cleanavis.application.gateway.IClassificationGateway;
import fr.esgi.cleanavis.application.gateway.IJeuGateway;
import fr.esgi.cleanavis.application.gateway.IPlateformeGateway;
import fr.esgi.cleanavis.application.interactors.IClassificationInputBoudary;
import fr.esgi.cleanavis.application.interactors.IJeuInputBoundary;
import fr.esgi.cleanavis.application.interactors.IPlateformeInputBoundary;
import fr.esgi.cleanavis.application.interactors.impl.ClassificationInteractor;
import fr.esgi.cleanavis.application.interactors.impl.JeuInteractor;
import fr.esgi.cleanavis.application.interactors.impl.PlateformeInteractor;
import fr.esgi.cleanavis.application.presenters.IClassificationPresenter;
import fr.esgi.cleanavis.application.presenters.IJeuPresenter;
import fr.esgi.cleanavis.application.presenters.IPlateformePresenter;
import fr.esgi.cleanavis.application.presenters.impl.ClassificationPresenterImpl;
import fr.esgi.cleanavis.application.presenters.impl.JeuPresenterImpl;
import fr.esgi.cleanavis.application.presenters.impl.PlateformePresenterImpl;
import fr.esgi.cleanavis.infrastructure.persistence.impl.ClassificationGatewayImpl;
import fr.esgi.cleanavis.infrastructure.persistence.impl.JeuGatewayImpl;
import fr.esgi.cleanavis.infrastructure.persistence.impl.PlateformeGatewayImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    public IPlateformePresenter plateformePresenter() {
        return new PlateformePresenterImpl();
    }

    public IPlateformeGateway plateformeGateway() {
        return new PlateformeGatewayImpl();
    }

    public IPlateformeInputBoundary plateformeInputBoundary(IPlateformePresenter plateformePresenter, IPlateformeGateway plateformeGateway) {
        return new PlateformeInteractor(plateformeGateway, plateformePresenter);
    }

    public IClassificationPresenter classificationPresenter() {return new ClassificationPresenterImpl();    }
    public IClassificationGateway classificationGateway(){return new ClassificationGatewayImpl();}
    public IClassificationInputBoudary classificationInputBoudary(
            IClassificationGateway classificationGateway,
            IClassificationPresenter classificationPresenter
    ){
        return new ClassificationInteractor(classificationGateway, classificationPresenter);
    }

    public IJeuGateway jeuGateway(){return new JeuGatewayImpl();}
    public IJeuPresenter jeuPresenter() {
        return new JeuPresenterImpl();
    }
    public IJeuInputBoundary jeuInputBoundary (
            IJeuGateway jeuGateway,
            IJeuPresenter jeuPresenter
    ) {
        return new JeuInteractor(jeuGateway, jeuPresenter);
    }
}
