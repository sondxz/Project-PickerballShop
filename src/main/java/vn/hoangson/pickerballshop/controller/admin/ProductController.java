package vn.hoangson.pickerballshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import vn.hoangson.pickerballshop.domain.Product;
import vn.hoangson.pickerballshop.service.ProductService;
import vn.hoangson.pickerballshop.service.UploadService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;


@Controller
public class ProductController {
    private final ProductService productService;
    private final UploadService uploadService;

    public ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/product")
    public String getProduct(Model model) {
        List<Product> products = this.productService.fetchProduct();
        model.addAttribute("products", products);
        return "admin/product/show";
    }
    
    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String postCreateProductPage(Model model, @ModelAttribute("newProduct") @Valid Product product,
            BindingResult newProductBindingResult, @RequestParam("productFile") MultipartFile file) {

        //validate
        if (newProductBindingResult.hasErrors()) {
            return "admin/product/create";
        }

        //upload file
        String images = this.uploadService.handleUploadFile(file, "products");
        product.setImage(images);

        //TODO: process POST request
        this.productService.createProduct(product);
        return "redirect:/admin/product";
    }
    
}
