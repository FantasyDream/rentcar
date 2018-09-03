package com.example.rentcar.controller;

import com.example.rentcar.model.User;
import com.example.rentcar.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/exist/{username}")
    public String exits(@PathVariable String username){
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode node = objectMapper.createObjectNode();
        if (userService.exits(username)==false){
            node.put("message","false");
            return node.toString();
        } else{
            node.put("message","true");
            return node.toString();
        }
    }


    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode node = objectMapper.createObjectNode();
        user=userService.loginCheck(user);
        if (user!=null){
            return objectMapper.writeValueAsString(user);
        } else {
            node.put("message","false");
            return node.toString();
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        System.out.println(user.getUsername());
        System.out.println(user.getUserinfo().getName());
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode node = objectMapper.createObjectNode();
        if(userService.register(user)){
            node.put("message","true");
            return node.toString();
        } else {
            node.put("message","false");
            return node.toString();
        }
    }
}
