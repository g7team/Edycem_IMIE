package fr.imie.edycem.controller;

import fr.imie.edycem.controller.base.AbstractController;
import fr.imie.edycem.model.Request.ProjectRequest;
import fr.imie.edycem.model.Response.ProjectResponse;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/projects")
public class ProjectController extends AbstractController<ProjectRequest , ProjectResponse> {


    /*
    @RequestMapping("/")
    public List<ProjectResponse> getProject() {
        return projectService.getAll();
    }

   @GetMapping(value = "/{id}")
    public ProjectResponse getById(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(projectService.getById(id));

    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponse createProject(@RequestBody ProjectRequest projectRequest) {
        Preconditions.checkNotNull(projectRequest);
        return this.projectService.create(projectRequest);
    }

    @PutMapping
    public ProjectResponse updateProject(@PathVariable( "id" ) Long id, @RequestBody ProjectRequest projectRequest) {
        Preconditions.checkNotNull(projectRequest);
        RestPreconditions.checkFound(this.projectService.getById(id));
        return this.projectService.update(projectRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProject(@PathVariable("id") Long id) {
        this.projectService.delete(id);
    }*/
}
