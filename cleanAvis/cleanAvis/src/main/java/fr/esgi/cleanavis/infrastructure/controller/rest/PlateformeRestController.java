package fr.esgi.cleanavis.infrastructure.controller.rest;

import fr.esgi.cleanavis.application.interactors.IPlateformeInputBoundary;
import fr.esgi.cleanavis.application.responseModels.PlateformeResponseModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/plateformes")
public class PlateformeRestController {

    private IPlateformeInputBoundary plateformeInputBoundary;

    @GetMapping("getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<PlateformeResponseModel> getPlateformes() {
        return plateformeInputBoundary.recupererPlateformesRest();
    }
}
