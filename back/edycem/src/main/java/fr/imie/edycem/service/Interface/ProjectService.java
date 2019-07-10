package fr.imie.edycem.service.Interface;

import fr.imie.edycem.model.Request.ProjectRequest;
import fr.imie.edycem.model.Response.ProjectResponse;

import java.util.List;

public interface ProjectService {

    List<ProjectResponse> getAll();

    ProjectResponse getById(Integer id);

    ProjectResponse create(ProjectRequest request);

    ProjectResponse update(ProjectRequest request);

    void delete(Integer id);
}
