package com.xiqi.wzq.core.service;

import com.xiqi.wzq.pojo.Result;

import java.util.List;

public interface VocabularyService {

    Result creatActiveReciteList(String category);

    Result getActiveReciteList(Integer numb);

    Result updateVocabularyStatus(List<String> words, Integer status);
}
