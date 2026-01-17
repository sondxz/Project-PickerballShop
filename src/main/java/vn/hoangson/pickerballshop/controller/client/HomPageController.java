package vn.hoangson.pickerballshop.controller.client;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

import vn.hoangson.pickerballshop.domain.Order;
import vn.hoangson.pickerballshop.domain.Product;
import vn.hoangson.pickerballshop.domain.User;
import vn.hoangson.pickerballshop.service.OrderService;
import vn.hoangson.pickerballshop.service.ProductService;

@Controller
public class HomPageController {

    private final ProductService productService;
    private final OrderService orderService;

    public HomPageController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        // List<Product> products = this.productService.fetchProduct();
        Pageable pageable = PageRequest.of(0, 12);
        Page<Product> prs = this.productService.fetchProduct(pageable);
        List<Product> products = prs.getContent();

        model.addAttribute("products", products);
        return "client/homepage/show";
    }

    @GetMapping("/order-history")
    public String getOrderHistoryPage(Model model, HttpServletRequest request) {
        User currentUser = new User();// null
        HttpSession session = request.getSession(false);
        long id = (long) session.getAttribute("id");
        currentUser.setId(id);

        List<Order> orders = this.orderService.fetchOrderByUser(currentUser);
        model.addAttribute("orders", orders);

        return "client/cart/order-history";
    }
}
