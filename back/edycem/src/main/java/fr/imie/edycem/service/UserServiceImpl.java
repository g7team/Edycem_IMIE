package fr.imie.edycem.service;

import fr.imie.edycem.exception.EdycemResourceNotFoundException;
import fr.imie.edycem.model.Request.UserRequest;
import fr.imie.edycem.model.Response.UserResponse;
import fr.imie.edycem.model.User;
import fr.imie.edycem.repository.UserRepository;
import fr.imie.edycem.service.Interface.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> listUser = this.userRepository.findAll();
        return listUser.stream().map(this::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse getById(Integer id) {
        Optional<User> optionalUser = this.userRepository.findById(id);

        if(optionalUser.isPresent()) {
            return this.dtoToResponse(optionalUser.get());
        } else {
            throw new EdycemResourceNotFoundException("User not found");
        }
    }

    @Override
    public UserResponse create(UserRequest request) {
        return dtoToResponse(this.userRepository.save(requestToDto(request)));
    }

    @Override
    public UserResponse update(UserRequest request) {
        return (UserResponse) this.userRepository.save(requestToDto(request));
    }

    @Override
    public void delete(Integer id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        this.userRepository.delete(optionalUser.get());
    }

    @Override
    public UserResponse login(UserRequest userRequest) {
        Optional<User> optionalUser = this.userRepository.findByMailAndPassword(this.requestToDto(userRequest));
        return optionalUser.map(this::dtoToResponse).orElse(null);
    }


    private UserResponse dtoToResponse(User project){
        this.mapper = new ModelMapper();
        return mapper.map(project, UserResponse.class);
    }

    private User requestToDto(UserRequest projectRequest) {
        this.mapper = new ModelMapper();
        return mapper.map(projectRequest ,User.class);
    }



}
