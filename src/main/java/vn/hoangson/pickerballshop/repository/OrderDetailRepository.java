package vn.hoangson.pickerballshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoangson.pickerballshop.domain.Order_Detail;

@Repository
public interface OrderDetailRepository extends JpaRepository<Order_Detail, Long> {
    
}
