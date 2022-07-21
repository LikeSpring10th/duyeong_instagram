package com.likespring.cloneinstagram.service;

/* import com.likespring.cloneinstagram.domain.user.UserRepository;
import com.likespring.cloneinstagram.web.dto.user.UserLoginDto;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;

public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User save(UserLoginDto userLoginDto){
        if(userRepository.findUserByEmail(userLoginDto.getEmail()) != null) return false;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return userRepository.save(User.builder()
                .email(userLoginDto.getEmail())
                .password(encoder.encode(userLoginDto.getPassword()))
                .phone(userLoginDto.getPhone())
                .name(userLoginDto.getName())
                .title(null)
                .website(null)
                .profileImgUrl("/img/default_profile.jpg")
                .build());
        return true;
        )
    }
}
*/

import com.likespring.cloneinstagram.domain.user.User;
import com.likespring.cloneinstagram.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User signup(User user){
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);

        User userEntity = userRepository.save(user);

        return userEntity;
    }

    @Transactional
    public User userUpdate(User user){
        User userEntity = userRepository.save(user);
        return userEntity;
    }
}