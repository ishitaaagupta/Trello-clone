//package com.trelloclone.ServiceImpl;
//
//import com.trelloclone.Model.User;
//import com.trelloclone.Repository.UserRepository;
//import com.trelloclone.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserServiceImple {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public User registerUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//    }
//
//    public User authenticateUser(String email, String password) {
//        Optional<User> userOpt = userRepository.findByEmail(email);
//        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
//            return userOpt.get();
//        }
//        throw new RuntimeException("Invalid credentials");
//    }
//
//
//}