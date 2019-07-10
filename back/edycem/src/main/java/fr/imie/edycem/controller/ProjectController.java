package fr.imie.edycem.controller;

import com.google.common.base.Preconditions;
import fr.imie.edycem.model.Request.ProjectRequest;
import fr.imie.edycem.model.Response.ProjectResponse;

import fr.imie.edycem.service.Interface.ProjectService;
import fr.imie.edycem.util.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/")
    public List<ProjectResponse> getProject() {
        return projectService.getAll();
    }

   @GetMapping(value = "/{id}")
    public ProjectResponse getById(@PathVariable("id") Integer id) {
        return RestPreconditions.checkFound(projectService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponse createProject(@RequestBody ProjectRequest projectRequest) {
        Preconditions.checkNotNull(projectRequest);
        return this.projectService.create(projectRequest);
    }

    @PutMapping(value = "/{id}")
    public ProjectResponse updateProject(@PathVariable( "id" ) Integer id, @RequestBody ProjectRequest projectRequest) {
        Preconditions.checkNotNull(projectRequest);
        RestPreconditions.checkFound(this.projectService.getById(id));
        return this.projectService.update(projectRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProject(@PathVariable("id") Integer id) {
        this.projectService.delete(id);
    }
}
