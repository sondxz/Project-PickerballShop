package vn.hoangson.pickerballshop.service.specification;

import org.springframework.boot.autoconfigure.rsocket.RSocketProperties.Server.Spec;
import org.springframework.data.jpa.domain.Specification;

import vn.hoangson.pickerballshop.domain.Product;
import vn.hoangson.pickerballshop.domain.Product_;

public class ProductSpecs {
    public static Specification<Product> nameLike(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Product_.NAME), "%" + name + "%");
    }
}
