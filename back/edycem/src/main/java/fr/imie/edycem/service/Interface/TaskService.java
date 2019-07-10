package fr.imie.edycem.service.Interface;

import fr.imie.edycem.model.Response.TaskResponse;

import java.util.List;

public interface TaskService {

    List<TaskResponse> getAll();
}
