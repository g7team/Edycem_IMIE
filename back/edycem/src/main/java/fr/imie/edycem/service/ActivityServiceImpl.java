package fr.imie.edycem.service;

import fr.imie.edycem.model.Activity;
import fr.imie.edycem.model.Request.ActivityRequest;
import fr.imie.edycem.model.Request.ProjectRequest;
import fr.imie.edycem.model.Response.ActivityResponse;
import fr.imie.edycem.repository.ActivityRepository;
import fr.imie.edycem.repository.ProjectRepository;
import fr.imie.edycem.service.Interface.ActivityService;
import fr.imie.edycem.service.Interface.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ProjectService projectService;

    private ModelMapper mapper;

    @Override
    public List<ActivityResponse> getAll() {
        List<Activity> activityList = this.activityRepository.findAll();
        return activityList.stream().map(this::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public List<ActivityResponse> getByProjectId(Integer projectId) {
        List<Activity> activityList = this.activityRepository.findAllByProjectId(projectId);
        return activityList.stream().map(this::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public ActivityResponse create(ActivityRequest activityRequest) {
        return null;
    }

    @Override
    public boolean getById(Integer id) {
        return false;
    }

    @Override
    public ActivityResponse update(ProjectRequest projectRequest) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    private ActivityResponse dtoToResponse(Activity activity){
        this.mapper = new ModelMapper();
        return mapper.map(activity, ActivityResponse.class);
    }

    private Activity requestToDto(ActivityRequest activityRequest) {
        this.mapper = new ModelMapper();
        return mapper.map(activityRequest ,Activity.class);
    }
}
