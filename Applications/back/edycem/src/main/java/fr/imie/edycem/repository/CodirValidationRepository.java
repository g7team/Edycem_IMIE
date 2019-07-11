package fr.imie.edycem.repository;

import fr.imie.edycem.model.CodirValidation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodirValidationRepository extends JpaRepository<CodirValidation, Integer> {
}
