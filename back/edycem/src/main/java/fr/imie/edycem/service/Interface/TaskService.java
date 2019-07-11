package fr.imie.edycem.service.Interface;

import fr.imie.edycem.model.Request.TaskRequest;
import fr.imie.edycem.model.Response.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAll();

    TaskResponse update(TaskRequest taskRequest);

    TaskResponse create(TaskRequest taskRequest);

    TaskResponse getById(Long id);

    void delete(Long id);
}
