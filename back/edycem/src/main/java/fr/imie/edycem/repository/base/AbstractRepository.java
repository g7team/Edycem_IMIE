package fr.imie.edycem.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


//public interface AbstractRepository<T> extends CrudRepository<T , Long> {
//
//}

public interface AbstractRepository<T> extends JpaRepository<T , Long> {

}
