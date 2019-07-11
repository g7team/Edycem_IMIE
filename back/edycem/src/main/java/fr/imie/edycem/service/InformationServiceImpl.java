package fr.imie.edycem.service;

import fr.imie.edycem.exception.EdycemResourceNotFoundException;
import fr.imie.edycem.model.Information;
import fr.imie.edycem.model.Request.InformationRequest;
import fr.imie.edycem.model.Response.InformationResponse;
import fr.imie.edycem.repository.InformationRepository;
import fr.imie.edycem.service.Interface.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationRepository informationRepository;

    @Override
    public InformationResponse getById(Integer id) throws EdycemResourceNotFoundException {
        Optional<Information> optionalInformation = this.informationRepository.findById(id);

        if(optionalInformation.isEmpty()) {
            throw new EdycemResourceNotFoundException("Resource Not Found");
        } else {
            return (InformationResponse) optionalInformation.get();
        }
    }

    @Override
    public InformationResponse create(InformationRequest informationRequest) {
        return (InformationResponse) informationRepository.save((Information) informationRequest);
    }

    @Override
    public InformationResponse update(InformationRequest informationRequest) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
