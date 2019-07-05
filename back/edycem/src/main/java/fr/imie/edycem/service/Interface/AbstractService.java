package fr.imie.edycem.service.Interface;

import java.util.List;

public interface AbstractService<Response, Request> {

    List<Response> getAll();

    Response getById(Long id);

    Response create(Request request);

    Response update(Request request);

    void delete(Long id);

}
