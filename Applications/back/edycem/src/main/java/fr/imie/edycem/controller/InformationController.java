package fr.imie.edycem.controller;

import fr.imie.edycem.model.Request.InformationRequest;
import fr.imie.edycem.model.Response.InformationResponse;
import fr.imie.edycem.service.Interface.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/projects/{project_id}/infomations")
public class InformationController {

    @Autowired
    InformationService informationService;

    @GetMapping(value = "/{id}")
    public InformationResponse getById(@PathVariable("id") Integer id) {
        return this.informationService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InformationResponse create(@RequestBody InformationRequest informationRequest) {
        return this.informationService.create(informationRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public InformationResponse update(@RequestBody InformationRequest informationRequest) {
        return this.informationService.update(informationRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        this.informationService.delete(id);
    }
}
