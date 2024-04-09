package com.xiqi.wzq.core.service;

import com.xiqi.wzq.pojo.Result;

public interface PersonService {


    Result register(String username,String password);

    Result login(String username,String password);

}
