package fr.esgi.cleanavis.application;

import fr.esgi.cleanavis.application.gateway.IPlateformeGateway;
import fr.esgi.cleanavis.application.interactors.impl.PlateformeInteractor;
import fr.esgi.cleanavis.application.presenters.IPlateformePresenter;
import fr.esgi.cleanavis.application.responseModels.JeuResponseModel;
import fr.esgi.cleanavis.application.responseModels.PlateformeResponseModel;
import fr.esgi.cleanavis.domain.Jeu;
import fr.esgi.cleanavis.domain.Plateforme;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class PlateformeInteractorTest {

    IPlateformePresenter mockedPresenter;
    IPlateformeGateway mockedGateway;


    @BeforeEach
    void setUp() {
        mockedGateway = Mockito.mock(IPlateformeGateway.class);
        mockedPresenter =  Mockito.mock(IPlateformePresenter.class);
    }

    @Test
    void shouldRecupererPlateformes() {
        // Given
        final List<Plateforme> plateformes = new ArrayList<>();
        final Plateforme plateforme1 = new Plateforme(1L, "PlayStation", null, LocalDate.of(1994, 12, 3));
        final Plateforme plateforme2 = new Plateforme(2L, "Xbox", null, LocalDate.of(2001, 11, 15));
        final Plateforme plateforme3 = new Plateforme(3L, "PC", null, LocalDate.of(1980, 1, 1));
        plateformes.add(plateforme1);
        plateformes.add(plateforme2);
        plateformes.add(plateforme3);
        final List<PlateformeResponseModel> responseModels = plateformes.stream()
                .map(plateforme -> new PlateformeResponseModel(
                        plateforme.getId(),
                        plateforme.getNom(),
                        plateforme.getDateDeSortie(),
                        mapJeuxToJeuResponseModel(plateforme.getJeux())
                ))
                .collect(Collectors.toList());
        final ModelAndView mv = new ModelAndView("plateformes");
        mv.addObject("plateformes", responseModels);

        // When
        Mockito.when(mockedGateway.recupererPlateformes()).thenReturn(plateformes);
        Mockito.when(mockedPresenter.prepareSuccessView(ArgumentMatchers.anyList())).thenReturn(mv);
        final PlateformeInteractor interactor = new PlateformeInteractor(mockedGateway, mockedPresenter);
        final ModelAndView response = interactor.recupererPlateformes();

        // Then
        Assertions.assertThat(response).isNotNull();
        Mockito.verify(mockedGateway, Mockito.times(1)).recupererPlateformes();
        Mockito.verify(mockedPresenter, Mockito.times(1)).prepareSuccessView(ArgumentMatchers.anyList());
        Assertions.assertThat(response.getModel()).isNotNull();
        Assertions.assertThat(response.getModel().get("plateformes")).isNotNull();
        Assertions.assertThat(response.getViewName()).isEqualTo("plateformes");
        // Vérification des plateformes dans la response
        List<PlateformeResponseModel> responsePlateformes = (List<PlateformeResponseModel>) response.getModel().get("plateformes");
        Assertions.assertThat(responsePlateformes).hasSize(3);

        PlateformeResponseModel responsePlateforme1 = responsePlateformes.get(0);
        Assertions.assertThat(responsePlateforme1.getId()).isEqualTo(1L);
        Assertions.assertThat(responsePlateforme1.getNom()).isEqualTo("PlayStation");
        Assertions.assertThat(responsePlateforme1.getDateDeSortie()).isEqualTo(LocalDate.of(1994, 12, 3));

        PlateformeResponseModel responsePlateforme2 = responsePlateformes.get(1);
        Assertions.assertThat(responsePlateforme2.getId()).isEqualTo(2L);
        Assertions.assertThat(responsePlateforme2.getNom()).isEqualTo("Xbox");
        Assertions.assertThat(responsePlateforme2.getDateDeSortie()).isEqualTo(LocalDate.of(2001, 11, 15));

        PlateformeResponseModel responsePlateforme3 = responsePlateformes.get(2);
        Assertions.assertThat(responsePlateforme3.getId()).isEqualTo(3L);
        Assertions.assertThat(responsePlateforme3.getNom()).isEqualTo("PC");
        Assertions.assertThat(responsePlateforme3.getDateDeSortie()).isEqualTo(LocalDate.of(1980, 1, 1));

        Assertions.assertThat(responsePlateforme1.getJeux()).isEmpty();
        Assertions.assertThat(responsePlateforme2.getJeux()).isEmpty();
        Assertions.assertThat(responsePlateforme3.getJeux()).isEmpty();
    }

    private List<JeuResponseModel> mapJeuxToJeuResponseModel(List<Jeu> jeux){
        if (jeux != null) {
            return jeux.stream()
                    .map(jeu -> new JeuResponseModel(
                            jeu.getId(),
                            jeu.getNom(),
                            jeu.getGenre().getNom(),
                            jeu.getClassification().getNom(),
                            jeu.getDescription(),
                            jeu.getDateDeSortie(),
                            jeu.getImage(),
                            jeu.getPrix()
                    ))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
