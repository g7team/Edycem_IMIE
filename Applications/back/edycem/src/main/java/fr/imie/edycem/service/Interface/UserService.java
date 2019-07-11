package fr.imie.edycem.service.Interface;

import fr.imie.edycem.model.Request.UserRequest;
import fr.imie.edycem.model.Response.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> getAll();

    UserResponse getById(Integer id);

    UserResponse create(UserRequest request);

    UserResponse update(UserRequest request);

    void delete(Integer id);

    UserResponse login(UserRequest userRequest);
}
