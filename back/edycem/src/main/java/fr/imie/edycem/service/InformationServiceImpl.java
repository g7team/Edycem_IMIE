package fr.imie.edycem.service;

import fr.imie.edycem.model.Response.InformationResponse;
import fr.imie.edycem.repository.InformationRepository;
import fr.imie.edycem.service.Interface.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    InformationRepository informationRepository;

    @Override
    public InformationResponse getById(Long id) {
        return (InformationResponse) informationRepository.findById(id);
    }
}
