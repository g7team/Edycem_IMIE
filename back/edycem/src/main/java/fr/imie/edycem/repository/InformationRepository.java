package fr.imie.edycem.repository;

import fr.imie.edycem.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information , Long> {
}
