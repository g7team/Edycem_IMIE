package fr.imie.edycem.controller;


import fr.imie.edycem.model.Request.TaskRequest;
import fr.imie.edycem.model.Response.TaskResponse;
import fr.imie.edycem.service.Interface.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/")
    public List<TaskResponse> getTask() {
        return this.taskService.getAll();
    }

    @GetMapping(value = "/{task_id}")
    public TaskResponse getById(@PathVariable("task_id") Long id) {
        return this.taskService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse create(@RequestBody TaskRequest taskRequest) {
        return this.taskService.create(taskRequest);
    }

    @PutMapping(value = "/{task_id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskResponse update(@PathVariable("task_id") Long task_id, @RequestBody TaskRequest taskRequest) {
        return this.taskService.update(taskRequest);
    }

    @DeleteMapping(value = "/{task_id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("task_id") Long id) {
        this.taskService.delete(id);
    }
}
