package fr.imie.edycem.service;

import fr.imie.edycem.model.Request.UserRequest;
import fr.imie.edycem.model.Response.UserResponse;
import fr.imie.edycem.repository.UserRepository;
import fr.imie.edycem.service.base.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends AbstractServiceImpl<UserRequest, UserResponse> {

    @Autowired
    private UserRepository userRepository;
/*
    @Override
    public List<UserResponse> getAll() {
        ArrayList<UserResponse> listProject = new ArrayList();
        listProject.add(new UserResponse());
        return listProject;
    }

    @Override
    public UserResponse getById(Long projectId) {
        return  new UserResponse();
    }

    @Override
    public UserResponse create(UserRequest request) {
        return null;
    }

    @Override
    public UserResponse update(UserRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
*/
}
