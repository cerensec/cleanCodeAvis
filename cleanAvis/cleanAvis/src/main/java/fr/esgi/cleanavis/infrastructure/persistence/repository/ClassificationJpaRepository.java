package fr.esgi.cleanavis.infrastructure.persistence.repository;

import fr.esgi.cleanavis.infrastructure.persistence.entity.ClassificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationJpaRepository extends JpaRepository<ClassificationEntity, Long> {
}
