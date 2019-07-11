package fr.imie.edycem.service;

import fr.imie.edycem.exception.EdycemResourceNotFoundException;
import fr.imie.edycem.model.Request.PartnerRequest;
import fr.imie.edycem.model.Response.PartnerResponse;
import fr.imie.edycem.model.Partner;
import fr.imie.edycem.repository.PartnerRepository;
import fr.imie.edycem.service.Interface.PartnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;

    private ModelMapper mapper;

    @Autowired
    public PartnerServiceImpl(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Override
    public List<PartnerResponse> getAll() {
        List<Partner> listPartner = this.partnerRepository.findAll();
        return listPartner.stream().map(this::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public PartnerResponse getById(Integer id) {
        Optional<Partner> optionalPartner = this.partnerRepository.findById(id);

        if(optionalPartner.isPresent()) {
            return this.dtoToResponse(optionalPartner.get());
        } else {
            throw new EdycemResourceNotFoundException("Partner not found");
        }
    }

    @Override
    public PartnerResponse create(PartnerRequest request) {
        return dtoToResponse(this.partnerRepository.save(requestToDto(request)));
    }

    @Override
    public PartnerResponse update(PartnerRequest request) {
        return (PartnerResponse) this.partnerRepository.save(requestToDto(request));
    }

    @Override
    public void delete(Integer id) {
        Optional<Partner> optionalPartner = this.partnerRepository.findById(id);
        this.partnerRepository.delete(optionalPartner.get());
    }

    private PartnerResponse dtoToResponse(Partner project){
        this.mapper = new ModelMapper();
        return mapper.map(project, PartnerResponse.class);
    }

    private Partner requestToDto(PartnerRequest projectRequest) {
        this.mapper = new ModelMapper();
        return mapper.map(projectRequest ,Partner.class);
    }
}
