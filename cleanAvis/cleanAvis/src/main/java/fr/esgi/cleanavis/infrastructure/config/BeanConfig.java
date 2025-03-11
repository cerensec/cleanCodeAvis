package fr.esgi.cleanavis.infrastructure.config;

import fr.esgi.cleanavis.application.gateway.IPlateformeGateway;
import fr.esgi.cleanavis.application.interactors.IPlateformeInputBoundary;
import fr.esgi.cleanavis.application.interactors.impl.PlateformeInteractor;
import fr.esgi.cleanavis.application.presenters.IPlateformePresenter;
import fr.esgi.cleanavis.application.presenters.impl.PlateformePresenterImpl;
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
}
