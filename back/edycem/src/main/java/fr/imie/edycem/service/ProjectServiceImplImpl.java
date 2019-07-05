package fr.imie.edycem.service;

import fr.imie.edycem.model.Request.ProjectRequest;
import fr.imie.edycem.model.Response.ProjectResponse;
import fr.imie.edycem.repository.ProjectRepository;
import fr.imie.edycem.service.base.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImplImpl extends AbstractServiceImpl<ProjectRequest,ProjectResponse> {

    @Autowired
    private ProjectRepository projectRepository;

    /*
    @Override
    public List<ProjectResponse> getAll() {
        ArrayList<ProjectResponse> listProject = new ArrayList();
        listProject.add(new ProjectResponse());
        return listProject;
    }

    @Override
    public ProjectResponse getById(Long projectId) {
        return  new ProjectResponse();
    }

    @Override
    public ProjectResponse create(ProjectRequest request) {
        return null;
    }

    @Override
    public ProjectResponse update(ProjectRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }*/
}
