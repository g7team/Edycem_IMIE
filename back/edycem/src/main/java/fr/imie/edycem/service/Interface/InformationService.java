package fr.imie.edycem.service.Interface;

import fr.imie.edycem.exception.MyResourceNotFoundException;
import fr.imie.edycem.model.Request.InformationRequest;
import fr.imie.edycem.model.Response.InformationResponse;

public interface InformationService {

    InformationResponse getById(Long id) throws MyResourceNotFoundException;

    InformationResponse create(InformationRequest informationRequest);

    InformationResponse update(InformationRequest informationRequest);

    void delete(Long id);
}
