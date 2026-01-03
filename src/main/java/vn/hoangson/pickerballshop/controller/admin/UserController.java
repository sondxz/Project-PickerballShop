package vn.hoangson.pickerballshop.controller.admin;

import vn.hoangson.pickerballshop.domain.User;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

import org.springframework.ui.Model;

import vn.hoangson.pickerballshop.service.UploadService;
import vn.hoangson.pickerballshop.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    // //DI: Dependency Injection
    private final UserService userService;
    private final UploadService uploadService;

    public UserController(UserService userService, UploadService uploadService) {
        this.userService = userService;
        this.uploadService = uploadService;
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
        List<User> users = this.userService.handleGetAllUsers();
        model.addAttribute("users1", users);
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/{id}")
    public String getDetailUserPage(Model model, @PathVariable long id) {
        User userById = this.userService.handleGetUsersById(id);
        model.addAttribute("user", userById);
        model.addAttribute("id", id);
        return "admin/user/user-detail";
    }

    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")
    public String createUserPage(Model model, @ModelAttribute("newUser") User user,
            @RequestParam("avatarFile") MultipartFile file) {
        // Handle upload file
        String avatar = this.uploadService.handleUploadFile(file, "avatar");

        System.out.println("Creating user..." + user);
        // this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User currentUser = this.userService.handleGetUsersById(id);
        model.addAttribute("newUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("newUser") User user) {
        User currentUser = this.userService.handleGetUsersById(user.getId());
        if (currentUser != null) {
            currentUser.setFullName(user.getFullName());
            currentUser.setPhone(user.getPhone());
            currentUser.setAddress(user.getAddress());

            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        // Cách 1:
        // User user = new User();
        // user.setId(id);
        model.addAttribute("newUser", new User());
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String getDeleteUserPage(Model model, @ModelAttribute("newUser") User user) {
        this.userService.handleDeleteUserById(user.getId());
        return "redirect:/admin/user";
    }
}
