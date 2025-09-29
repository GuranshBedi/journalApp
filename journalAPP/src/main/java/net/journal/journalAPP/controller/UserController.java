package net.journal.journalAPP.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.journal.journalAPP.api.response.WeatherResponse;
import net.journal.journalAPP.entity.User;
import net.journal.journalAPP.service.EmailService;
import net.journal.journalAPP.service.UserService;
import net.journal.journalAPP.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import net.journal.journalAPP.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name="User APIs" , description = "Create Read Update & Delete")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public void saveEntry(@RequestBody User user){
        userService.saveNewUser(user);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User old = userService.findByUserName(userName);
            old.setUserName(user.getUserName());
            old.setPassword(user.getPassword());
            userService.saveNewUser(old); //so that on that id , details are updated
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/weather")
    public ResponseEntity<?> weather(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("MUMBAI");
        String greeting = "";
        if(weatherResponse != null)
            greeting = ", Weather feels like " + weatherResponse.getCurrent().getFeelsLike();
        return new ResponseEntity<>("Hi " + authentication.getName() + greeting,HttpStatus.OK);
    }

}
