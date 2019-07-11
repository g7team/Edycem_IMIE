package fr.imie.edycem.repository;

import fr.imie.edycem.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    List<Activity> findAllByProjectId(Integer projectId);

}
