package fr.imie.edycem.service.Interface;

import fr.imie.edycem.model.Request.InventionRequest;
import fr.imie.edycem.model.Response.InventionResponse;

import java.util.List;

public interface InventionService {

    List<InventionResponse> getAll();

    InventionResponse getById(Integer id);

    InventionResponse create(InventionRequest inventionRequest);

    InventionResponse update(InventionRequest inventionRequest);

    void delete(Integer id);
}
