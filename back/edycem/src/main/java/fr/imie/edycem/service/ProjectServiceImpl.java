package fr.imie.edycem.service;

import fr.imie.edycem.exception.EdycemResourceNotFoundException;
import fr.imie.edycem.model.Project;
import fr.imie.edycem.model.Request.ProjectRequest;
import fr.imie.edycem.model.Response.ProjectResponse;
import fr.imie.edycem.repository.ProjectRepository;
import fr.imie.edycem.service.Interface.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    private ModelMapper mapper;

    @Override
    public List<ProjectResponse> getAll() {
        List<Project> projectList  = this.projectRepository.findAll();
        return projectList.stream()
                .map(this::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectResponse getById(Integer id) {
        Optional<Project> optionalProject = this.projectRepository.findById(id);
        if (optionalProject.isEmpty()) throw new EdycemResourceNotFoundException("Project not found");
        else return this.dtoToResponse(optionalProject.get());
    }

    @Override
    public ProjectResponse create(ProjectRequest request) {
        Project project = requestToDto(request);
        Project newProject = this.projectRepository.save(project);
        ProjectResponse projectResponse = dtoToResponse(newProject);
        return projectResponse;
    }

    @Override
    public ProjectResponse update(ProjectRequest request) {
        return dtoToResponse(this.projectRepository.save(requestToDto(request)));
    }

    @Override
    public void delete(Integer id) {
        Optional<Project> optionalProject = this.projectRepository.findById(id);
        this.projectRepository.delete(optionalProject.get());
    }

    private ProjectResponse dtoToResponse(Project project){
        this.mapper = new ModelMapper();
        return mapper.map(project, ProjectResponse.class);
    }

    private Project requestToDto(ProjectRequest projectRequest) {
        this.mapper = new ModelMapper();
        return mapper.map(projectRequest ,Project.class);
    }

}
