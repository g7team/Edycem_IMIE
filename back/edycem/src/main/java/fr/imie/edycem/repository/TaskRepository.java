package fr.imie.edycem.repository;

import fr.imie.edycem.model.Task;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
=======
import fr.imie.edycem.repository.base.AbstractRepository;

public interface TaskRepository extends AbstractRepository<Task> {
>>>>>>> create tasks
}
