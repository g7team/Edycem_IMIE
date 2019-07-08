package fr.imie.edycem.controller;

import fr.imie.edycem.controller.base.AbstractController;
import fr.imie.edycem.model.Request.UserRequest;
import fr.imie.edycem.model.Response.UserResponse;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/users")
public class UserController extends AbstractController<UserRequest , UserResponse>{

    /*
    @RequestMapping("/")
    public List<UserResponse> getUser() {
        return userService.getAll();
    }

   @GetMapping(value = "/{id}")
    public UserResponse getById(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(userService.getById(id));

    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        Preconditions.checkNotNull(userRequest);
        return this.userService.create(userRequest);
    }

    @PutMapping(value = "/{id}")
    public UserResponse updateUser(@PathVariable( "id" ) Long id, @RequestBody UserRequest userRequest) {
        Preconditions.checkNotNull(userRequest);
        RestPreconditions.checkFound(this.userService.getById(id));
        return this.userService.update(userRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") Long id) {
        this.userService.delete(id);
    }*/
}
