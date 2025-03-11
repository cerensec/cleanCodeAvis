package fr.esgi.cleanavis.application.interactors;

import fr.esgi.cleanavis.application.responseModels.PlateformeResponseModel;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface IPlateformeInputBoundary {
    ModelAndView recupererPlateformes();
}
