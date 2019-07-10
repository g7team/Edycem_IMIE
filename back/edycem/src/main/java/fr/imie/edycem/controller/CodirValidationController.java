package fr.imie.edycem.controller;

import fr.imie.edycem.model.Request.CodirValidationRequest;
import fr.imie.edycem.model.Response.CodirValidationResponse;
import fr.imie.edycem.service.Interface.CodirValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/projects/{project_id}/validations")
public class CodirValidationController {

    private CodirValidationService codirValidationService;

    @Autowired
    public CodirValidationController(CodirValidationService codirValidationService) {
        this.codirValidationService = codirValidationService;
    }

    @GetMapping(value = "/{id}")
    public CodirValidationResponse getById(@PathVariable("id") Integer id , @PathVariable("project_id") Integer projectId) {
        return this.codirValidationService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CodirValidationResponse create(@RequestBody CodirValidationRequest codirValidationRequest) {
        return this.codirValidationService.create(codirValidationRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CodirValidationResponse update(@RequestBody CodirValidationRequest codirValidationRequest) {
        return this.codirValidationService.update(codirValidationRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        this.codirValidationService.delete(id);
    }
}
