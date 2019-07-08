package fr.imie.edycem.controller.base;

import fr.imie.edycem.service.Interface.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AbstractController<Response,Request> {

    @Autowired
    private AbstractService<Response, Request> service;

    /*
    public AbstractController(AbstractService<Response, Request> service) {
        this.service = service;
    }
    */

    @RequestMapping("/")
    List<Response> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    public Response getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response create(@RequestBody Request request){
        return this.service.create(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Response update(@PathVariable("id") Long id , @RequestBody Request request) {
        return service.update(request);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        this.service.delete(id);
    }

}
