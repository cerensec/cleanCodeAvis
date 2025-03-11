package fr.esgi.cleanavis.infrastructure.persistence.repository;

import fr.esgi.cleanavis.infrastructure.persistence.entity.JeuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JeuJpaRepository extends JpaRepository<JeuEntity, Long> {
}
