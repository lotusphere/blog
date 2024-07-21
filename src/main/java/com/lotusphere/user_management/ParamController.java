package com.lotusphere.user_management;

import org.springframework.web.bind.annotation.*;

@RestController
public class ParamController {
    @GetMapping("/noAnnotation")
    public User noAnnotation(User user) {
        return user;
    }

    @GetMapping("/requestParam")
    public User requestParam(@RequestParam String name, @RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @GetMapping("/pathVariable/{name}/{age}")
    public User pathVariable(@PathVariable String name, @PathVariable int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("/requestBody")
    public User requestBody(@RequestBody User user) {
        return user;
    }
}
