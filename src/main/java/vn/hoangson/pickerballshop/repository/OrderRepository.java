package vn.hoangson.pickerballshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoangson.pickerballshop.domain.Order;
import vn.hoangson.pickerballshop.domain.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
