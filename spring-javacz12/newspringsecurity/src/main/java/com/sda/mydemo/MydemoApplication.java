package com.sda.mydemo;

import com.sda.mydemo.models.User;
import com.sda.mydemo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class MydemoApplication implements CommandLineRunner {

    private  final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public MydemoApplication(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MydemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("John");
        user.setPassword(passwordEncoder.encode("123"));
        user.setRoles(List.of("ROLE_USER"));

        userRepository.save(user);
    }
}
