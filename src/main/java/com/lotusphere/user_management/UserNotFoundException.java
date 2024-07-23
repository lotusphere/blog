package com.lotusphere.user_management;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id) {
        super("User with id " + id + "not found");
    }
}
