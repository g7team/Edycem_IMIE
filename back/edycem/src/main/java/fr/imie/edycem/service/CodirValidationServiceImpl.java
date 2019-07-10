package fr.imie.edycem.service;

import fr.imie.edycem.model.Request.CodirValidationRequest;
import fr.imie.edycem.model.Response.CodirValidationResponse;
import fr.imie.edycem.repository.CodirValidationRepository;
import fr.imie.edycem.service.Interface.CodirValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodirValidationServiceImpl implements CodirValidationService {

    private final CodirValidationRepository codirValidationRepository;

    @Autowired
    public CodirValidationServiceImpl(CodirValidationRepository codirValidationRepository) {
        this.codirValidationRepository = codirValidationRepository;
    }

    @Override
    public List<CodirValidationResponse> getAll() {
        return null;
    }

    @Override
    public CodirValidationResponse getById(Integer id) {
        return null;
    }

    @Override
    public CodirValidationResponse create(CodirValidationRequest codirValidationRequest) {
        return null;
    }

    @Override
    public CodirValidationResponse update(CodirValidationRequest codirValidationRequest) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public CodirValidationResponse getByProjectId(Long id) { return null; }
}
