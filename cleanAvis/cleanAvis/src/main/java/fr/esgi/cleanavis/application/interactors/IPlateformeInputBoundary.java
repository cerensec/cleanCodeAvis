package fr.esgi.cleanavis.application.interactors;

import fr.esgi.cleanavis.application.responseModels.PlateformeResponseModel;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * The interface Plateforme input boundary.
 */
public interface IPlateformeInputBoundary {
    /**
     * Recuperer plateformes model and view.
     *
     * @return the model and view
     */
    ModelAndView recupererPlateformes();

    /**
     * Recuperer plateformes rest list.
     *
     * @return the list
     */
    List<PlateformeResponseModel> recupererPlateformesRest();
}
