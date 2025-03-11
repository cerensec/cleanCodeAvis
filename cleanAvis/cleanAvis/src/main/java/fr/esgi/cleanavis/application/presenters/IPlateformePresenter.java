package fr.esgi.cleanavis.application.presenters;

import fr.esgi.cleanavis.application.responseModels.PlateformeResponseModel;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * The interface Plateforme presenter.
 */
public interface IPlateformePresenter {
    /**
     * Prepare success view model and view.
     *
     * @param responseModels the response models
     * @return the model and view
     */
    ModelAndView prepareSuccessView(List<PlateformeResponseModel> responseModels);

    /**
     * Prepare fail view model and view.
     *
     * @param responseModels the response models
     * @return the model and view
     */
    ModelAndView prepareFailView(List<PlateformeResponseModel> responseModels);

    /**
     * Prepare succes rest reesponse list.
     *
     * @param responseModels the response models
     * @return the list
     */
    List<PlateformeResponseModel> prepareSuccesRestReesponse(final List<PlateformeResponseModel> responseModels);
}
