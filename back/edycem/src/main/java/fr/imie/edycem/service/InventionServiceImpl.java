package fr.imie.edycem.service;

import fr.imie.edycem.exception.EdycemResourceNotFoundException;
import fr.imie.edycem.model.Invention;
import fr.imie.edycem.model.Request.InventionRequest;
import fr.imie.edycem.model.Response.InventionResponse;
import fr.imie.edycem.repository.InventionRepository;
import fr.imie.edycem.service.Interface.InventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventionServiceImpl implements InventionService {

    @Autowired
    private InventionRepository inventionRepository;

    @Override
    public List<InventionResponse> getAll() {
        return null;
    }

    @Override
    public InventionResponse getById(Integer id) {
        Optional<Invention> optionalInvention  = this.inventionRepository.findById(id);
        if (optionalInvention.isEmpty()) {
            throw new EdycemResourceNotFoundException("Invention not found");
        } else {
            return (InventionResponse) optionalInvention.get();
        }


    }

    @Override
    public InventionResponse create(InventionRequest inventionRequest) {
        return null;
    }

    @Override
    public InventionResponse update(InventionRequest inventionRequest) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
