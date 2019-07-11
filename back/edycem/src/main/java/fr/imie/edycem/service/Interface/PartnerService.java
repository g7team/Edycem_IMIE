package fr.imie.edycem.service.Interface;

import fr.imie.edycem.model.Request.PartnerRequest;
import fr.imie.edycem.model.Response.PartnerResponse;

import java.util.List;

public interface PartnerService {

    List<PartnerResponse> getAll();

    PartnerResponse getById(Integer id);

    PartnerResponse create(PartnerRequest request);

    PartnerResponse update(PartnerRequest request);

    void delete(Integer id);
}
