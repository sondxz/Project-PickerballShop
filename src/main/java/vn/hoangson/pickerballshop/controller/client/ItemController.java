package vn.hoangson.pickerballshop.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.ui.Model;
import vn.hoangson.pickerballshop.domain.Product;
import vn.hoangson.pickerballshop.service.ProductService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ItemController {
    private final ProductService productService;

    public ItemController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public String getProductPage(Model model, @PathVariable long id) {
        Product product = this.productService.fetchProductById(id).get();
        model.addAttribute("product", product);
        model.addAttribute("id", id);

        // Lấy danh sách sản phẩm liên quan (tất cả sản phẩm, loại trừ sản phẩm hiện
        // tại){AI}
        List<Product> relatedProducts = this.productService.fetchProduct()
                .stream()
                .filter(p -> p.getId() != id)
                .limit(8)
                .toList();
        model.addAttribute("relatedProducts", relatedProducts);

        return "client/product/detail";
    }

}
