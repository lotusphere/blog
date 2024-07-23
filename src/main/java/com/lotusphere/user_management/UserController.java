package com.lotusphere.user_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/birthday")
    public List<User> getByBirthday(String birthday) {
        return userRepository.findByBirthday(LocalDate.parse(birthday));
    }

    public List<User> getByBirthdayNative(String birthday) {
        return userRepository.findByBirthdayNative(birthday);
    }
}
