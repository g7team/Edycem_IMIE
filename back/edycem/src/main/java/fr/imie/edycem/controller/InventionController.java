package fr.imie.edycem.controller;

import fr.imie.edycem.controller.base.AbstractController;
import fr.imie.edycem.model.Request.InventionRequest;
import fr.imie.edycem.model.Response.InventionResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="projects/{project_id}/inventions")
public class InventionController extends AbstractController<InventionRequest, InventionResponse>{

    /*
    @RequestMapping("/")
    public List<InventionResponse> getInvention() {
        return inventionService.getAll();
    }

    @GetMapping(value = "/{id}")
    public InventionResponse getById(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(inventionService.getById(id));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventionResponse createInvention(@RequestBody InventionRequest inventionRequest) {
        Preconditions.checkNotNull(inventionRequest);
        return this.inventionService.create(inventionRequest);
    }

    @PutMapping(value = "/{id}")
    public InventionResponse updateInvention(@PathVariable( "id" ) Long id, @RequestBody InventionRequest inventionRequest) {
        Preconditions.checkNotNull(inventionRequest);
        RestPreconditions.checkFound(this.inventionService.getById(id));
        return this.inventionService.update(inventionRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteInvention(@PathVariable("id") Long id) {
        this.inventionService.delete(id);
    }*/
}
