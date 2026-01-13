package vn.hoangson.pickerballshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoangson.pickerballshop.domain.Cart;
import vn.hoangson.pickerballshop.domain.CartDetail;
import vn.hoangson.pickerballshop.domain.Product;
import vn.hoangson.pickerballshop.domain.User;
import vn.hoangson.pickerballshop.repository.CartDetailRepository;
import vn.hoangson.pickerballshop.repository.CartRepository;
import vn.hoangson.pickerballshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CartDetailRepository cartDetailRepository;
    private final CartRepository cartRepository;
    private final UserService userService;

    public ProductService(ProductRepository productRepository, CartDetailRepository cartDetailRepository,
            CartRepository cartRepository, UserService userService) {
        this.productRepository = productRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.cartRepository = cartRepository;
        this.userService = userService;
    }

    public List<Product> fetchProduct() {
        return this.productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return this.productRepository.save(product);
    }

    public Optional<Product> fetchProductById(long id) {
        return this.productRepository.findById(id);
    }

    public void deleteProduct(long id) {
        this.productRepository.deleteById(id);
    }

    public void handleAddProductToCart(String email, long productId) {
       
        User user = this.userService.getUserByEmail(email);
        if (user != null) {
            // check user đã có cart chưa ? nếu chưa thì tạo mới
            Cart cart = this.cartRepository.findByUser(user);
            if (cart == null) {
                // tạo mới cart
                Cart otherCart = new Cart();
                otherCart.setUser(user);
                otherCart.setSum(1);

                cart = this.cartRepository.save(otherCart);
            }

            // tìm product by id
            Optional<Product> productOpt = this.productRepository.findById(productId);
            if (productOpt.isPresent()) {
                Product realProduct = productOpt.get();

                // lưu cart_detail
                CartDetail cartDetail = new CartDetail();
                cartDetail.setCart(cart);
                cartDetail.setProduct(realProduct);
                cartDetail.setPrice(realProduct.getPrice());
                cartDetail.setQuantity(1);

                this.cartDetailRepository.save(cartDetail);
            }

        }

    }
}
