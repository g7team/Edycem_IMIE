package fr.imie.edycem.controller;

import fr.imie.edycem.model.Response.TaskResponse;
import fr.imie.edycem.service.Interface.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/")
    public List<TaskResponse> getTask() {
        return this.taskService.getAll();
    }
}
