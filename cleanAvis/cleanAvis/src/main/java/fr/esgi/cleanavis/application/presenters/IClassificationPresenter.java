package fr.esgi.cleanavis.application.presenters;

import fr.esgi.cleanavis.application.responseModels.ClassificationResponseModel;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface IClassificationPresenter {
    ModelAndView prepareSuccessView(List<ClassificationResponseModel> responseModels);
    ModelAndView prepareFailView(List<ClassificationResponseModel> responseModels);
}
