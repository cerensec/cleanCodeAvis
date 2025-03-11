package fr.esgi.cleanavis.controller;

import fr.esgi.cleanavis.application.interactors.impl.JeuInteractor;
import fr.esgi.cleanavis.application.presenters.IJeuPresenter;
import fr.esgi.cleanavis.application.gateway.IJeuGateway;
import fr.esgi.cleanavis.application.responseModels.JeuResponseModel;
import fr.esgi.cleanavis.domain.Editeur;
import fr.esgi.cleanavis.domain.Jeu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JeuControllerTest {
    // @Autowired
    // MockMvc mockMvc;

    // private Faker faker = new Faker(Locale.FRENCH);

    IJeuPresenter mockedPresenter;
    IJeuGateway mockedGateway;

    @BeforeEach
    void setUp() {
        mockedGateway = Mockito.mock(IJeuGateway.class);
        mockedPresenter = Mockito.mock(IJeuPresenter.class);
    }

    @Test
    void testGetAllJeux() throws Exception {
        // Given
        final List<Jeu> jeux = new ArrayList<>();

        final Editeur editeur1 = new Editeur("Bethesda");
        final Editeur editeur2= new Editeur("Valve");
        final Editeur editeur3 = new Editeur("GT Interactive Software");

        final Jeu jeu1 = new Jeu(
                1L,
                "Fallout: New Vegas",
                editeur1,
                null,
                null,
                "description1",
                LocalDate.of(2010, 10, 22),
                new ArrayList<>(),
                "image1",
                10.50F
        );
        final Jeu jeu2 = new Jeu(
                2L,
                "Half-Life",
                editeur2,
                null,
                null,
                "description2",
                LocalDate.of(1997, 9, 22),
                new ArrayList<>(),
                "image2",
                9.99F
        );
        final Jeu jeu3 = new Jeu(
                3L,
                "Blood",
                editeur3,
                null,
                null,
                "description3",
                LocalDate.of(1997, 8, 22),
                new ArrayList<>(),
                "image3",
                7.99F
        );
        jeux.add(jeu1);
        jeux.add(jeu2);
        jeux.add(jeu3);
        final List<JeuResponseModel> responseModels = jeux.stream()
                .map(jeu -> new JeuResponseModel(
                        jeu.getId(),
                        jeu.getNom(),
                        jeu.getClassification().getNom(),
                        jeu.getGenre().getNom(),
                        jeu.getDescription(),
                        jeu.getDateDeSortie(),
                        jeu.getImage(),
                        jeu.getPrix()/*,
                        jeu.getEditeur().getNom() */
                ))
                .collect(Collectors.toList());
        final ModelAndView mv = new ModelAndView("jeux");
        mv.addObject("jeux", responseModels);

        // When
        Mockito.when(mockedGateway.recupererJeux()).thenReturn(jeux);
        Mockito.when(mockedPresenter.prepareSuccessViewGetAll(ArgumentMatchers.anyList())).thenReturn(mv);
        final JeuInteractor interactor = new JeuInteractor(mockedGateway, mockedPresenter);
        final ModelAndView response = interactor.recupererJeux();

        // Then
        Assertions.assertThat(response).isNotNull();
        Mockito.verify(mockedGateway, Mockito.times(1)).recupererJeux();
        Mockito.verify(mockedPresenter, Mockito.times(1)).prepareSuccessViewGetAll(ArgumentMatchers.anyList());
        Assertions.assertThat(response.getModel()).isNotNull();
        Assertions.assertThat(response.getModel().get("Jeux")).isNotNull();
        Assertions.assertThat(response.getViewName()).isEqualTo("Jeux");
        // Vérification du nombre de jeux dans la response
        List<JeuResponseModel> responseJeux = (List<JeuResponseModel>) response.getModel().get("Jeux");
        Assertions.assertThat(responseJeux).hasSize(3);

        JeuResponseModel responseJeu1 = responseJeux.get(0);
        Assertions.assertThat(responseJeu1.getId()).isEqualTo(1L);
        Assertions.assertThat(responseJeu1.getNom()).isEqualTo("Fallout: New Vegas");
        // Assertions.assertThat(responseJeu1.getEditeur()).isEqualTo(editeur1);
        Assertions.assertThat(responseJeu1.getGenre()).isEqualTo(null);
        Assertions.assertThat(responseJeu1.getClassification()).isEqualTo(null);
        Assertions.assertThat(responseJeu1.getDescription()).isEqualTo("description1");
        Assertions.assertThat(responseJeu1.getDateDeSortie()).isEqualTo(LocalDate.of(2010, 10, 22));
        // Assertions.assertThat(responseJeu1.getPlateformes()).isEqualTo(new ArrayList<>());
        Assertions.assertThat(responseJeu1.getImage()).isEqualTo("image1");
        Assertions.assertThat(responseJeu1.getPrix()).isEqualTo(10.50F);

        JeuResponseModel responseJeu2 = responseJeux.get(1);
        Assertions.assertThat(responseJeu2.getId()).isEqualTo(2L);
        Assertions.assertThat(responseJeu2.getNom()).isEqualTo("Half-Life");
        // Assertions.assertThat(responseJeu2.getEditeur()).isEqualTo(editeur2);
        Assertions.assertThat(responseJeu2.getGenre()).isEqualTo(null);
        Assertions.assertThat(responseJeu2.getClassification()).isEqualTo(null);
        Assertions.assertThat(responseJeu2.getDescription()).isEqualTo("description2");
        Assertions.assertThat(responseJeu2.getDateDeSortie()).isEqualTo(LocalDate.of(1997, 9, 22));
        // Assertions.assertThat(responseJeu2.getPlateformes()).isEqualTo(new ArrayList<>());
        Assertions.assertThat(responseJeu2.getImage()).isEqualTo("image2");
        Assertions.assertThat(responseJeu2.getPrix()).isEqualTo(9.99F);

        JeuResponseModel responseJeu3 = responseJeux.get(2);
        Assertions.assertThat(responseJeu3.getId()).isEqualTo(3L);
        Assertions.assertThat(responseJeu3.getNom()).isEqualTo("Blood");
        // Assertions.assertThat(responseJeu3.getEditeur()).isEqualTo(editeur3);
        Assertions.assertThat(responseJeu3.getGenre()).isEqualTo(null);
        Assertions.assertThat(responseJeu3.getClassification()).isEqualTo(null);
        Assertions.assertThat(responseJeu3.getDescription()).isEqualTo("description3");
        Assertions.assertThat(responseJeu3.getDateDeSortie()).isEqualTo(LocalDate.of(1997, 8, 22));
        // Assertions.assertThat(responseJeu3.getPlateformes()).isEqualTo(new ArrayList<>());
        Assertions.assertThat(responseJeu3.getImage()).isEqualTo("image3");
        Assertions.assertThat(responseJeu3.getPrix()).isEqualTo(7.99F);
    }
}
