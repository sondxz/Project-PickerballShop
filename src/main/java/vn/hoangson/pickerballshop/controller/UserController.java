package vn.hoangson.pickerballshop.controller;

import vn.hoangson.pickerballshop.domain.User;
import vn.hoangson.pickerballshop.repository.UserRepository;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.ui.Model;
import vn.hoangson.pickerballshop.service.UserService;

@Controller
public class UserController {

    // //DI: Dependency Injection
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> arrUser = this.userService.handleGetAllUsersByEmail("seomonx7@gmail.com");
        System.out.println("arrUser: " + arrUser);
        model.addAttribute("message", "test");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "/admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User user) {
        System.out.println("Creating user..." + user);
        this.userService.handleSaveUser(user);
        return "hello";
    }
}
