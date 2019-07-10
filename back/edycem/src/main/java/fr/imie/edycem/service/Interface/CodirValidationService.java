package fr.imie.edycem.service.Interface;


import fr.imie.edycem.model.Request.CodirValidationRequest;
import fr.imie.edycem.model.Response.CodirValidationResponse;

import java.util.List;

public interface CodirValidationService{

    List<CodirValidationResponse> getAll();

    CodirValidationResponse getById(Integer id);

    CodirValidationResponse create(CodirValidationRequest codirValidationRequest);

    CodirValidationResponse update(CodirValidationRequest codirValidationRequest);

    void delete(Integer id);
}
