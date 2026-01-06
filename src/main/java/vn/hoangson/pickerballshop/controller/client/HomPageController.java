package vn.hoangson.pickerballshop.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String getHomePage(Model model) {
        List<Product> products = this.productService.fetchProduct();
        model.addAttribute("products", products);
        return "client/homepage/show";
    }
    
}
