package com.xiqi.wzq.core.controller;

import com.xiqi.wzq.core.service.WordService;
import com.xiqi.wzq.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping
    public Result wordInfo(@RequestParam("word") String word){
        return wordService.findByWord(word);
    }

}
