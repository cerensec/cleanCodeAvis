package fr.esgi.cleanavis.application.presenters.impl;

import fr.esgi.cleanavis.application.presenters.IClassificationPresenter;
import fr.esgi.cleanavis.application.responseModels.ClassificationResponseModel;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class ClassificationPresenterImpl implements IClassificationPresenter {
    @Override
    public ModelAndView prepareSuccessView(List<ClassificationResponseModel> responseModels) {
        return new ModelAndView("classifications").addObject("classifications", responseModels);
    }

    @Override
    public ModelAndView prepareFailView(List<ClassificationResponseModel> responseModels) {
        return new ModelAndView("classifications").addObject("classifications", responseModels);
    }
}
