package fr.imie.edycem.controller;

import fr.imie.edycem.controller.base.AbstractController;
import fr.imie.edycem.model.Request.UserRequest;
import fr.imie.edycem.model.Response.UserResponse;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/users")
public class UserController extends AbstractController<UserRequest , UserResponse>{

}
