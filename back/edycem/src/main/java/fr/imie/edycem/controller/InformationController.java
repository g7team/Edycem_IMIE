package fr.imie.edycem.controller;

import fr.imie.edycem.controller.base.AbstractController;
import fr.imie.edycem.model.Request.InformationRequest;
import fr.imie.edycem.model.Response.InformationResponse;
import fr.imie.edycem.service.Interface.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/projects/{project_id}/infomations")
public class InformationController extends AbstractController<InformationResponse, InformationRequest> {

    @Autowired
    InformationService informationService;

    @GetMapping(value = "/{id}")
    public InformationResponse getById(@PathVariable("id") Long id) {
        return this.informationService.getById(id);
    }


}
