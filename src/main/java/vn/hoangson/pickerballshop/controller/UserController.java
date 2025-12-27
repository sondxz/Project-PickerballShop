package vn.hoangson.pickerballshop.controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.hoangson.pickerballshop.service.UserService;


// @Controller
// public class UserController {

//     @RequestMapping("/")
//     public String getHomePage() {
//         return "Welcome to Pickerball Shop!";
//     }
// }

@RestController
public class UserController {

    //DI: Dependency Injection
    private UserService userService; 

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getHomePage() {
        return this.userService.handleHello();
    }
}
