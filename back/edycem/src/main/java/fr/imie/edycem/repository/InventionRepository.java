package fr.imie.edycem.repository;

import fr.imie.edycem.model.Invention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventionRepository extends JpaRepository<Invention, Integer> {
}
