package com.shoppingApp.security_service.service;


import com.shoppingApp.security_service.entity.User;
import com.shoppingApp.security_service.repository.UserRepository;
import com.shoppingApp.security_service.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final JwtUtil jwtUtil;

    public String login(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return jwtUtil.generateToken(username, user.getRole());
    }

    public void register(String username, String password, String role) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role(role)
                .build();
        userRepository.save(user);
    }
}
