package fr.imie.edycem.service.Interface;

import fr.imie.edycem.model.Request.ActivityRequest;
import fr.imie.edycem.model.Request.ProjectRequest;
import fr.imie.edycem.model.Response.ActivityResponse;

import java.util.List;

public interface ActivityService {

    List<ActivityResponse> getAll();

    ActivityResponse create(ActivityRequest activityRequest);

    boolean getById(Integer id);

    ActivityResponse update(ProjectRequest projectRequest);

    void delete(Integer id);
}
