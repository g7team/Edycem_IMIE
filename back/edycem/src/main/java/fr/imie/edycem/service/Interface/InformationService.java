package fr.imie.edycem.service.Interface;

import fr.imie.edycem.exception.EdycemResourceNotFoundException;
import fr.imie.edycem.model.Request.InformationRequest;
import fr.imie.edycem.model.Response.InformationResponse;

public interface InformationService {

    InformationResponse getById(Integer id) throws EdycemResourceNotFoundException;

    InformationResponse create(InformationRequest informationRequest);

    InformationResponse update(InformationRequest informationRequest);

    void delete(Integer id);
}
