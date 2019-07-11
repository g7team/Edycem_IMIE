package fr.imie.edycem.service.Interface;

import fr.imie.edycem.model.Request.TimeSpentRequest;
import fr.imie.edycem.model.Response.TimeSpentResponse;

import java.util.List;

public interface TimeSpentService {

    List<TimeSpentResponse> getAll();

    List<TimeSpentResponse> getByProjectId(Integer projectId);

    TimeSpentResponse getById(Integer id);

    TimeSpentResponse create(TimeSpentRequest request);

    TimeSpentResponse update(TimeSpentRequest request);

    void delete(Integer id);

}
