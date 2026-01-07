package vn.hoangson.pickerballshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoangson.pickerballshop.domain.Role;
import vn.hoangson.pickerballshop.domain.User;
import vn.hoangson.pickerballshop.domain.DTO.RegisterDTO;
import vn.hoangson.pickerballshop.repository.RoleRepository;
import vn.hoangson.pickerballshop.repository.UserRepository;

@Service
public class UserService {
    public final UserRepository userRepository;
    public final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> handleGetAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users;
    }

    public List<User> handleGetAllUsersByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User handleGetUsersById(long id) {
        return this.userRepository.findById(id);
    }

    public User handleSaveUser(User user) {
        User inUser = this.userRepository.save(user);
        return inUser;
    }

    public void handleDeleteUserById(long id) {
        this.userRepository.deleteById(id);
    }

    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }

    public User registerDTOtoUser(RegisterDTO registerDTO) {
        User user = new User();
        user.setFullName(registerDTO.getFirstName() + " " + registerDTO.getLastName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        return user;
    }

    public boolean checkEmailExist(String email) {
        return this.userRepository.existsByEmail(email);
    }
}
