package com.xiqi.wzq.core.service.impl;

import com.xiqi.wzq.core.service.PersonService;
import com.xiqi.wzq.entity.Person;
import com.xiqi.wzq.entity.Token;
import com.xiqi.wzq.pojo.Result;
import com.xiqi.wzq.repo.PersonRepository;
import com.xiqi.wzq.repo.TokenRepository;
import com.xiqi.wzq.utils.JwtUtils;
import com.xiqi.wzq.utils.SpringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository = SpringUtils.getBean(PersonRepository.class);

    private final TokenRepository tokenRepository = SpringUtils.getBean(TokenRepository.class);


    @Override
    public Result register(String username,String password) {
        if (personRepository.findByUsername(username) == null) {
            personRepository.save(new Person(username, password));
            return Result.success();
        } else {
            return Result.error("用户名已被占用！");
        }
    }

    @Override
    public Result login(String username, String password) {
        Person loginPerson = personRepository.findByUsername(username);

        if (loginPerson == null) {
            return Result.error("用户名错误");
        }

        if (password.equals(loginPerson.getPassword())){

            Date date = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);

            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id",loginPerson.getAccount());
            claims.put("username",username);
            String token = JwtUtils.genToken(claims,date);

            tokenRepository.save(new Token(token,date));


            return Result.success(token);
        }

        return Result.error("密码错误");
    }
}
