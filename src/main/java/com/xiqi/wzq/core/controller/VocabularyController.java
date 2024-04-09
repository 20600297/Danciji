package com.xiqi.wzq.core.controller;

import com.xiqi.wzq.core.service.VocabularyService;
import com.xiqi.wzq.entity.dto.UpdateVocabularyStatusDto;
import com.xiqi.wzq.enums.WordCategoryName;
import com.xiqi.wzq.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vocabulary")
public class VocabularyController {

    @Autowired
    VocabularyService vocabularyService;

    @PostMapping
    public Result creatActiveReciteList(@RequestParam("category") String category ){

        if (WordCategoryName.isContains(category)){
            return vocabularyService.creatActiveReciteList(category);
        } else {
            return Result.error("分类不存在！");
        }

    }

    @GetMapping
    public Result getActiveReciteList(@RequestParam("numb") Integer numb){

        if (numb > 0){
            return vocabularyService.getActiveReciteList(numb);
        } else {
            return Result.error("参数错误！");
        }
    }


    @PatchMapping
    public Result updateVocabularyStatus(@RequestBody UpdateVocabularyStatusDto updatedto){

        Integer wordnumb = updatedto.getWordNumb();
        List<String> words = updatedto.getWords();

        if ( words.size() == wordnumb ){
            return vocabularyService.updateVocabularyStatus(words,updatedto.getStatus());
        } else {
            return Result.error("数据异常！");
        }

    }

}
