package com.xiqi.wzq.core.controller;

import com.xiqi.wzq.core.service.PersonService;
import com.xiqi.wzq.pojo.Result;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PatchMapping("/update/password")
    public Result updatePassword(@RequestBody Map<String,String> updateInfo){

        String oldPwd = updateInfo.get("old_password");
        String newPwd = updateInfo.get("new_password");
        String rePwd = updateInfo.get("re_password");

        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)){
            return Result.error("缺少必要参数");
        }

        if (!rePwd.equals(newPwd)){
            return Result.error("两次填写的新密码不一致");
        }

        return personService.updatePassword(oldPwd,newPwd);

    }

}
