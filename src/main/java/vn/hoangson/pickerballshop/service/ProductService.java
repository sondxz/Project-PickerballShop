package vn.hoangson.pickerballshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoangson.pickerballshop.domain.Product;
import vn.hoangson.pickerballshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> fetchProduct() {
        return this.productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return this.productRepository.save(product);
    }
}
