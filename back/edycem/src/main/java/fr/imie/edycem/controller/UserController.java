package fr.imie.edycem.controller;

import com.google.common.base.Preconditions;
import fr.imie.edycem.model.Request.UserRequest;
import fr.imie.edycem.model.Response.UserResponse;
import fr.imie.edycem.service.Interface.UserService;
import fr.imie.edycem.util.RestPreconditions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public List<UserResponse> getUser() {
        return userService.getAll();
    }

    @PostMapping("/login/")
    public UserResponse getUser(@RequestBody UserRequest userRequest) {
        return this.userService.login(userRequest);
    }

   @GetMapping(value = "/{id}")
    public UserResponse getById(@PathVariable("id") Integer id) {
        return RestPreconditions.checkFound(userService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        Preconditions.checkNotNull(userRequest);
        return this.userService.create(userRequest);
    }

    @PutMapping(value = "/{id}")
    public UserResponse updateUser(@PathVariable( "id" ) Integer id, @RequestBody UserRequest userRequest) {
        Preconditions.checkNotNull(userRequest);
        RestPreconditions.checkFound(this.userService.getById(id));
        return this.userService.update(userRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") Integer id) {
        this.userService.delete(id);
    }
}
