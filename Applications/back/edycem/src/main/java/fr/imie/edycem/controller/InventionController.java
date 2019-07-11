package fr.imie.edycem.controller;

import com.google.common.base.Preconditions;
import fr.imie.edycem.model.Request.InventionRequest;
import fr.imie.edycem.model.Response.InventionResponse;
import fr.imie.edycem.service.Interface.InventionService;
import fr.imie.edycem.util.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="projects/{project_id}/inventions")
public class InventionController {

    @Autowired
    private InventionService inventionService;

    @GetMapping("/")
    public List<InventionResponse> getInvention() {
        return inventionService.getAll();
    }

    @GetMapping(value = "/{id}")
    public InventionResponse getById(@PathVariable("id") Integer id) {
        return RestPreconditions.checkFound(inventionService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventionResponse createInvention(@RequestBody InventionRequest inventionRequest) {
        Preconditions.checkNotNull(inventionRequest);
        return this.inventionService.create(inventionRequest);
    }

    @PutMapping(value = "/{id}")
    public InventionResponse updateInvention(@PathVariable("project_id") Integer project_id ,
                                             @RequestBody InventionRequest inventionRequest) {
        Preconditions.checkNotNull(inventionRequest);
        RestPreconditions.checkFound(this.inventionService.getById(project_id));
        return this.inventionService.update(inventionRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteInvention(@PathVariable("id") Integer id) {
        this.inventionService.delete(id);
    }
}
