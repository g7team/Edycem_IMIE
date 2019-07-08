package fr.imie.edycem.repository;

import fr.imie.edycem.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends JpaRepository<Information , Long> {
}
