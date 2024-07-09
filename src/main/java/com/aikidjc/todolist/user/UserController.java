package com.aikidjc.todolist.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    private IUserRepository userRepository;
    /**
     * 
     * @param userModel
     */
    @PostMapping("/")
    public UserModel create(@RequestBody UserModel userModel){
        this.userRepository.findByUsername(userModel.getUsername());
        var userCreated = this.userRepository.save(userModel);
        return userCreated;
    }
}
