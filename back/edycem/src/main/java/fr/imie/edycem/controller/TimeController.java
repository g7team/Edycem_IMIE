package fr.imie.edycem.controller;

import fr.imie.edycem.model.Request.TimeSpentRequest;
import fr.imie.edycem.model.Response.TimeSpentResponse;
import fr.imie.edycem.service.Interface.TimeSpentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/timeSpent")
public class TimeController {

    @Autowired
    private TimeSpentService timeSpentService;


    @RequestMapping("/")
    public List<TimeSpentResponse> getAll() {
        return timeSpentService.getAll();
    }

    @GetMapping(value = "/{project_id}")
    public List<TimeSpentResponse> getByProjectId(@PathVariable("project_id") Integer projectId) {
        return this.timeSpentService.getByProjectId(projectId);
    }

    @GetMapping(value = "/{id}")
    public TimeSpentResponse getById(@PathVariable("id") Integer id) {
        return timeSpentService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TimeSpentResponse create(@RequestBody TimeSpentRequest request){
        return this.timeSpentService.create(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public TimeSpentResponse update(@PathVariable("id") Integer id , @RequestBody TimeSpentRequest request) {
        return timeSpentService.update(request);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        this.timeSpentService.delete(id);
    }

}
