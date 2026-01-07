package vn.hoangson.pickerballshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RegisterController {
    
    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        return "client/auth/register";
    }
    
}
