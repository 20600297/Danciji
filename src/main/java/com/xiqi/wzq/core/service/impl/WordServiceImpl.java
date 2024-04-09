package com.xiqi.wzq.core.service.impl;

import com.xiqi.wzq.core.service.WordService;
import com.xiqi.wzq.entity.word.Word;
import com.xiqi.wzq.pojo.Result;
import com.xiqi.wzq.repo.WordRepository;
import com.xiqi.wzq.utils.SpringUtils;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository = SpringUtils.getBean(WordRepository.class);
    @Override
    public Result findByWord(String wordstring) {
        Word word = wordRepository.findByWord(wordstring);

        if (word != null) {
            return Result.success(word);
        } else {
            return Result.error("所查单词不存在！");
        }
    }



}
