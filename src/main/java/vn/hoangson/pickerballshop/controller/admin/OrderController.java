package vn.hoangson.pickerballshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class OrderController {
    
    @GetMapping("/admin/order")
    public String index() {
        return "admin/order/show";
    }
}
