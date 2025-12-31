package vn.hoangson.pickerballshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.hoangson.pickerballshop.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User save(User user);
}
