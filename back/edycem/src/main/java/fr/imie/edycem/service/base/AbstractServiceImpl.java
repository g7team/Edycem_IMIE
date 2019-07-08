package fr.imie.edycem.service.base;

import fr.imie.edycem.repository.base.AbstractRepository;
import fr.imie.edycem.service.Interface.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class AbstractServiceImpl<Response, Request> implements AbstractService<Response,Request> {

    AbstractRepository<Response> repository;

    public List<Response> getAll() {
        return repository.findAll();
    }

    public Response getById(Long id) {
        boolean isActive = repository.findById(id).isPresent();

        if(!isActive) {
            return null;
        } else {
            return repository.findById(id).get();
        }
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
