package com.likespring.cloneinstagram.web.controller.api;

import com.likespring.cloneinstagram.domain.user.User;
import com.likespring.cloneinstagram.service.UserService;
import com.likespring.cloneinstagram.web.dto.user.UserLoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping({"/login" , "/"})
    public String LoginForm(){
        return "login";
    }

    @GetMapping("/signup")
    public String SignupForm(){
        return "signup";
    }

    @PostMapping("/signup")
    public String Signup(UserLoginDto userLoginDto){
        User user = userLoginDto.toEntity();

        User userEntity = userService.signup(user);

        return "login";
    }
}