package fr.imie.edycem.repository;

import fr.imie.edycem.model.Invention;
import fr.imie.edycem.repository.base.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventionRepository extends AbstractRepository<Invention> {
}
