package vn.hoangson.pickerballshop.service;

import org.springframework.stereotype.Service;

import vn.hoangson.pickerballshop.domain.User;
import vn.hoangson.pickerballshop.repository.UserRepository;

@Service
public class UserService {
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleSaveUser(User user) {
        User inUser = this.userRepository.save(user);
        return inUser;
    }
}
