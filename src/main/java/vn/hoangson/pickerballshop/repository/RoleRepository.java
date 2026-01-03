package vn.hoangson.pickerballshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoangson.pickerballshop.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // insert into users value
    Role findByName(String name);
}
