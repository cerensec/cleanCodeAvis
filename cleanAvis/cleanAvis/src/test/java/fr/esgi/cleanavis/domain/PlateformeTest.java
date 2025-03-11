package fr.esgi.cleanavis.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

 class PlateformeTest {
    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void shouldFailWhenNomIsNull() {
        // Given
        Plateforme plateforme = new Plateforme();

        // When
        final Set<ConstraintViolation<Plateforme>> violations = validator.validate(plateforme);

        // Then
        assert !violations.isEmpty();
        assert violations.iterator().next().getMessage().equals("Nom cannot be null");
    }

    @Test
    void shouldCreatePlateformeObject() {
        // Given
        final Plateforme plateforme = new Plateforme(10L, "Xbox", Collections.emptyList(), LocalDate.now());

        // Then
        Assertions.assertThat(plateforme).isNotNull();
        Assertions.assertThat(plateforme.getNom()).isEqualTo("Xbox");
        Assertions.assertThat(plateforme.getDateDeSortie()).isEqualTo(LocalDate.now());
    }
}
