package fr.imie.edycem.controller;

import com.google.common.base.Preconditions;
import fr.imie.edycem.model.Request.ActivityRequest;
import fr.imie.edycem.model.Request.ProjectRequest;
import fr.imie.edycem.model.Response.ActivityResponse;
import fr.imie.edycem.service.Interface.ActivityService;
import fr.imie.edycem.util.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
 @RequestMapping(value="/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;


    @GetMapping("/")
    public List<ActivityResponse> getActivity() {
        return this.activityService.getAll();
    }

    @GetMapping(value = "/{project_id}")
    public List<ActivityResponse> getByProjectId(@PathVariable("project_id") Integer id) {
        return this.activityService.getByProjectId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ActivityResponse createActivity(@RequestBody ActivityRequest activityRequest) {
        Preconditions.checkNotNull(activityRequest);
        return this.activityService.create(activityRequest);
    }

    @PutMapping(value = "/{id}")
    public ActivityResponse updateActivity(@PathVariable( "id" ) Integer id, @RequestBody ProjectRequest projectRequest) {
        Preconditions.checkNotNull(projectRequest);
        RestPreconditions.checkFound(this.activityService.getById(id));
        return this.activityService.update(projectRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteActivity(@PathVariable("id") Integer id) {
        this.activityService.delete(id);
    }
}
