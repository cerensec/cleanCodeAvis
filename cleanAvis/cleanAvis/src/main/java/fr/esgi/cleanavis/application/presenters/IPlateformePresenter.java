package fr.esgi.cleanavis.application.presenters;

import fr.esgi.cleanavis.application.responseModels.PlateformeResponseModel;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface IPlateformePresenter {
    ModelAndView prepareSuccessView(List<PlateformeResponseModel> responseModels);
    ModelAndView prepareFailView(List<PlateformeResponseModel> responseModels);
}
