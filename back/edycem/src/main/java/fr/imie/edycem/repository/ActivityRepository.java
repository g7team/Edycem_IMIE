package fr.imie.edycem.repository;

import fr.imie.edycem.model.Activity;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    List<Activity> findAllByProjectId(Integer projectId);
=======
import fr.imie.edycem.model.Task;
import fr.imie.edycem.repository.base.AbstractRepository;

public interface ActivityRepository extends AbstractRepository<Activity> {
>>>>>>> create activity
}
