package vn.hoangson.pickerballshop.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;
import vn.hoangson.pickerballshop.domain.Product;
import vn.hoangson.pickerballshop.service.ProductService;

@Controller
public class HomPageController {
    
    private final ProductService productService;

    

    public HomPageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getHomePage(Model model, HttpServletRequest request) {
        List<Product> products = this.productService.fetchProduct();
        model.addAttribute("products", products);
        HttpSession session = request.getSession(false);

        return "client/homepage/show";
    }
    
}
