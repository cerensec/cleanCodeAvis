package fr.esgi.cleanavis.controller;

import com.github.javafaker.Faker;
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

        final Jeu jeu1 = new Jeu("Fallout: New Vegas", LocalDate.of(2010, 10, 22), editeur1);
        final Jeu jeu2 = new Jeu("Half-Life", LocalDate.of(1997, 9, 22), editeur2);
        final Jeu jeu3 = new Jeu("Blood", LocalDate.of(1997, 8, 22), editeur3);
        jeux.add(jeu1);
        jeux.add(jeu2);
        jeux.add(jeu3);
        final List<JeuResponseModel> responseModels = jeux.stream()
                .map(jeu -> new JeuResponseModel(
                        jeu.getId(),
                        jeu.getNom(),
                        "genre",
                        "classification",
                        "description",
                        jeu.getDateDeSortie(),
                        "image",
                        0.33F
                       // jeu.getEditeur()
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
        // Vérification des Jeux dans la response
        List<JeuResponseModel> responseJeux = (List<JeuResponseModel>) response.getModel().get("Jeux");
        Assertions.assertThat(responseJeux).hasSize(3);

        JeuResponseModel responseJeu1 = responseJeux.get(0);
        // Assertions.assertThat(responseJeu1.getId()).isEqualTo(0L);
        Assertions.assertThat(responseJeu1.getNom()).isEqualTo("Fallout: New Vegas");
        Assertions.assertThat(responseJeu1.getGenre()).isEqualTo("genre");
        Assertions.assertThat(responseJeu1.getClassification()).isEqualTo("classification");
        Assertions.assertThat(responseJeu1.getDescription()).isEqualTo("description");
        Assertions.assertThat(responseJeu1.getDateDeSortie()).isEqualTo(LocalDate.of(2010, 10, 22));
        Assertions.assertThat(responseJeu1.getImage()).isEqualTo("image");
        Assertions.assertThat(responseJeu1.getPrix()).isEqualTo(0.33F);

        JeuResponseModel responseJeu2 = responseJeux.get(1);
        // Assertions.assertThat(responseJeu1.getId()).isEqualTo(1L);
        Assertions.assertThat(responseJeu1.getNom()).isEqualTo("Half-Life");
        Assertions.assertThat(responseJeu1.getGenre()).isEqualTo("genre");
        Assertions.assertThat(responseJeu1.getClassification()).isEqualTo("classification");
        Assertions.assertThat(responseJeu1.getDescription()).isEqualTo("description");
        Assertions.assertThat(responseJeu1.getDateDeSortie()).isEqualTo(LocalDate.of(1997, 9, 22));
        Assertions.assertThat(responseJeu1.getImage()).isEqualTo("image");
        Assertions.assertThat(responseJeu1.getPrix()).isEqualTo(0.33F);

        JeuResponseModel responseJeu3 = responseJeux.get(2);
        // Assertions.assertThat(responseJeu1.getId()).isEqualTo(2L);
        Assertions.assertThat(responseJeu1.getNom()).isEqualTo("Blood");
        Assertions.assertThat(responseJeu1.getGenre()).isEqualTo("genre");
        Assertions.assertThat(responseJeu1.getClassification()).isEqualTo("classification");
        Assertions.assertThat(responseJeu1.getDescription()).isEqualTo("description");
        Assertions.assertThat(responseJeu1.getDateDeSortie()).isEqualTo(LocalDate.of(1997, 8, 22));
        Assertions.assertThat(responseJeu1.getImage()).isEqualTo("image");
        Assertions.assertThat(responseJeu1.getPrix()).isEqualTo(0.33F);
    }
}
