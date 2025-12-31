package vn.hoangson.pickerballshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoangson.pickerballshop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //insert into users value
    User save(User user);

    List<User> findByEmail(String email);

    List<User> findAll();

    User findById(long id);
}
