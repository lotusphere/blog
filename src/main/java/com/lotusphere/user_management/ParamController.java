package com.lotusphere.user_management;

import org.springframework.web.bind.annotation.*;

@RestController
public class ParamController {
    @GetMapping("/no-annotation")
    public User noAnnotation(User user) {
        return user;
    }

    @GetMapping("/request-param")
    public User requestParam(@RequestParam String name, @RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @GetMapping("/path-variable/{name}/{age}")
    public User pathVariable(@PathVariable String name, @PathVariable int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("/request-body")
    public User requestBody(@RequestBody User user) {
        return user;
    }
}
