package fr.imie.edycem.repository;

import fr.imie.edycem.model.User;
import fr.imie.edycem.repository.base.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractRepository<User> {
}
