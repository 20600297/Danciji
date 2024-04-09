package com.xiqi.wzq.core.controller;

import com.xiqi.wzq.core.service.PersonService;
import com.xiqi.wzq.pojo.Result;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\d{5,16}$") String password){

        return personService.register(username,password);
    }

    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\d{5,16}$") String password){

        return personService.login(username,password);
    }

}
