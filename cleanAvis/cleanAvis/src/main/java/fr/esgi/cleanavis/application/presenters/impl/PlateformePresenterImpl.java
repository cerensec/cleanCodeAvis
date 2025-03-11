package fr.esgi.cleanavis.application.presenters.impl;

import fr.esgi.cleanavis.application.presenters.IPlateformePresenter;
import fr.esgi.cleanavis.application.responseModels.PlateformeResponseModel;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class PlateformePresenterImpl implements IPlateformePresenter {

    @Override
    public ModelAndView prepareSuccessView(List<PlateformeResponseModel> responseModels) {
        final ModelAndView mv = new ModelAndView("plateformes");
        mv.addObject("plateformes", responseModels);
        return mv;
    }

    @Override
    public ModelAndView prepareFailView(List<PlateformeResponseModel> responseModels) {
        return new ModelAndView("plateformes").addObject("plateformes", responseModels);
    }
}
