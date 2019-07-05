package fr.imie.edycem.service.base;

import fr.imie.edycem.repository.base.AbstractRepository;
import fr.imie.edycem.service.Interface.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class AbstractServiceImpl<Response, Request> implements AbstractService<Response,Request> {

    AbstractRepository repository;

    public List<Response> getAll() {
        return null;
    }

    public Response getById(Long id) {
        return null;
    }

    public Response create(Request request) {
        return null;
    }

    public Response update(Request request) {
        return null;
    }

    public void delete(Long id) {

    }

}
