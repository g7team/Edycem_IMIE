package fr.imie.edycem.service;

import fr.imie.edycem.model.Request.TaskRequest;
import fr.imie.edycem.model.Response.TaskResponse;
import fr.imie.edycem.model.Task;
import fr.imie.edycem.repository.TaskRepository;
import fr.imie.edycem.service.Interface.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskResponse> getAll() {
        List<Task> taskList = this.taskRepository.findAll();
        List<TaskResponse> taskResponseList = taskList.stream()
                .map(task -> (TaskResponse) task)
                .collect(Collectors.toList());
        return taskResponseList;
    }

    @Override
    public TaskResponse getById(Long id) {
        return null;
    }

    @Override
    public TaskResponse create(TaskRequest taskRequest) {
        return null;
    }

    @Override
    public TaskResponse update(TaskRequest taskRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

}
