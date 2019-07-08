package fr.imie.edycem.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractRepository<T> extends JpaRepository<T , Long> {

}
