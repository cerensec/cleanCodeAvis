package fr.esgi.cleanavis.infrastructure.persistence.repository;

import fr.esgi.cleanavis.infrastructure.persistence.entity.PlateformeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlateformeJpaRepository extends JpaRepository<PlateformeEntity, Long> {
}
