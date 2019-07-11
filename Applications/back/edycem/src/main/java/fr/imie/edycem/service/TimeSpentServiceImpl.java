package fr.imie.edycem.service;

import fr.imie.edycem.exception.EdycemResourceNotFoundException;
import fr.imie.edycem.model.Request.TimeSpentRequest;
import fr.imie.edycem.model.Response.TimeSpentResponse;
import fr.imie.edycem.model.TimeSpent;
import fr.imie.edycem.repository.TimeSpentRepository;
import fr.imie.edycem.service.Interface.TimeSpentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TimeSpentServiceImpl implements TimeSpentService {

    private final TimeSpentRepository repository;

    private ModelMapper mapper;

    @Autowired
    public TimeSpentServiceImpl(TimeSpentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TimeSpentResponse> getAll() {
        List<TimeSpent> timeSpentList = this.repository.findAll();
        return timeSpentList.stream().map(this::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public List<TimeSpentResponse> getByProjectId(Integer projectId) {
        List<TimeSpent> timeSpentList = this.repository.findAllByProjectId(projectId);
        return timeSpentList.stream().map(this::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public TimeSpentResponse getById(Integer id) {
        Optional<TimeSpent> optionalTimeSpent = this.repository.findById(id);
        if (optionalTimeSpent.isEmpty()) throw new EdycemResourceNotFoundException("TimeSpent not found");
        else return dtoToResponse(optionalTimeSpent.get());
    }

    @Override
    public TimeSpentResponse create(TimeSpentRequest request) {
        return dtoToResponse(this.repository.save(requestToDto(request)));
    }

    @Override
    public TimeSpentResponse update(TimeSpentRequest request) {
        return this.dtoToResponse(this.repository.saveAndFlush(this.requestToDto(request)));
    }

    @Override
    public void delete(Integer id) {
        Optional<TimeSpent> optionalTimeSpent = this.repository.findById(id);
        optionalTimeSpent.ifPresent(this.repository::delete);
    }

    private TimeSpentResponse dtoToResponse(TimeSpent timeSpent){
        this.mapper = new ModelMapper();
        return mapper.map(timeSpent, TimeSpentResponse.class);
    }

    private TimeSpent requestToDto(TimeSpentRequest timeSpentRequest) {
        this.mapper = new ModelMapper();
        return mapper.map(timeSpentRequest ,TimeSpent.class);
    }
}
