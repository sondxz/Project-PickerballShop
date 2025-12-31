package vn.hoangson.pickerballshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoangson.pickerballshop.domain.User;
import vn.hoangson.pickerballshop.repository.UserRepository;

@Service
public class UserService {
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> handleGetAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users;
    }

    public List<User> handleGetAllUsersByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User handleSaveUser(User user) {
        User inUser = this.userRepository.save(user);
        return inUser;
    }
}
