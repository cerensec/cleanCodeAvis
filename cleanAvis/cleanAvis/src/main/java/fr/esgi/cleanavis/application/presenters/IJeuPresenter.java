package fr.esgi.cleanavis.application.presenters;

import fr.esgi.cleanavis.application.responseModels.JeuResponseModel;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface IJeuPresenter {
    ModelAndView prepareSuccessViewGetAll(List<JeuResponseModel> responseModels);
    ModelAndView prepareFailViewGetAll(List<JeuResponseModel> responseModels);
    ModelAndView prepareSuccessViewForOne(JeuResponseModel responseModel);
    ModelAndView prepareFailViewForOne(JeuResponseModel responseModel);
}
