package fr.esgi.cleanavis.application.presenters.impl;

import fr.esgi.cleanavis.application.presenters.IJeuPresenter;
import fr.esgi.cleanavis.application.responseModels.JeuResponseModel;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class JeuPresenterImpl implements IJeuPresenter {
    @Override
    public ModelAndView prepareSuccessViewGetAll(List<JeuResponseModel> responseModels) {
        return new ModelAndView("jeux").addObject("jeux", responseModels);
    }

    @Override
    public ModelAndView prepareFailViewGetAll(List<JeuResponseModel> responseModels) {
        return new ModelAndView("jeux").addObject("jeux", responseModels);
    }

    @Override
    public ModelAndView prepareSuccessViewForOne(JeuResponseModel responseModel) {
        return new ModelAndView("jeu").addObject("jeu", responseModel);
    }

    @Override
    public ModelAndView prepareFailViewForOne(JeuResponseModel responseModel) {
        return new ModelAndView("jeu").addObject("jeu", responseModel);
    }
}
