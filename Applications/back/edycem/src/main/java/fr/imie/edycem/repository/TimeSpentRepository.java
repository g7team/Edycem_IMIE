package fr.imie.edycem.repository;

import fr.imie.edycem.model.TimeSpent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSpentRepository extends JpaRepository<TimeSpent, Integer> {

    List<TimeSpent> findAllByProjectId(Integer projectId);
}
