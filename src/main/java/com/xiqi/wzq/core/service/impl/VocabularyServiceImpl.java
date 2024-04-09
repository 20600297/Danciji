package com.xiqi.wzq.core.service.impl;

import com.xiqi.wzq.core.service.VocabularyService;
import com.xiqi.wzq.entity.Person;
import com.xiqi.wzq.entity.Vocabulary;
import com.xiqi.wzq.entity.word.Word;
import com.xiqi.wzq.enums.VocabularyStatusName;
import com.xiqi.wzq.pojo.Result;
import com.xiqi.wzq.repo.PersonRepository;
import com.xiqi.wzq.repo.VocabularyRepository;
import com.xiqi.wzq.repo.WordRepository;
import com.xiqi.wzq.utils.SpringUtils;
import com.xiqi.wzq.utils.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VocabularyServiceImpl implements VocabularyService {

    VocabularyRepository vocabularyRepository = SpringUtils.getBean(VocabularyRepository.class);
    WordRepository wordRepository = SpringUtils.getBean(WordRepository.class);
    PersonRepository personRepository = SpringUtils.getBean(PersonRepository.class);
    private final Random random = new Random();

    @Override
    public Result creatActiveReciteList(String category) {

        List<Word> categoryList = wordRepository.findAllByCategory(category);

        List<Vocabulary> vocabularyList = vocabularyRepository.findAllByCategory(category);

        if (categoryList == null){
            return Result.error("单词库异常！");
        }

        if (vocabularyList.size() != 0){
            return Result.error("此分类的单词已经在背诵列表了！");
        }

        Map<String, Object> claims = ThreadLocalUtil.get();

        Person person = personRepository.findByUsername((String) claims.get("username"));

        categoryList.forEach(e -> {
            Vocabulary vocabulary = new Vocabulary();
            vocabulary.setCategory(category);
            vocabulary.setStatus(VocabularyStatusName.Pending.getStatus());
            vocabulary.setWord(e);
            vocabulary.setPerson(person);

            vocabularyList.add(vocabulary);
        });

        vocabularyRepository.saveAll(vocabularyList);

        return Result.success();
    }

    @Override
    public Result getActiveReciteList(Integer numb) {

        long pendingNumb = vocabularyRepository.countAllByStatus(VocabularyStatusName.Pending.getStatus());

        if (pendingNumb == 0) {
            return Result.error("没有单词了呢！");
        }

        int maxEid = Math.toIntExact(pendingNumb);

        Set<Long> eidSet = new HashSet<>();

        while (eidSet.size() < numb) {
            int randomNumber = random.nextInt(maxEid) + 1;
            eidSet.add((long)randomNumber);
        }

        // TODO
        return Result.success(vocabularyRepository.findAllById(eidSet));
    }

    @Override
    public Result updateVocabularyStatus(List<String> words, Integer status) {

        List<Vocabulary> allByWord = vocabularyRepository.findAllByWord(words);

        if (allByWord.size() == words.size()){

            allByWord.forEach(v ->v.setStatus(status));
            vocabularyRepository.saveAll(allByWord);

            return Result.success();

        } else if(allByWord.size() > 0) {

            allByWord.forEach(v ->v.setStatus(status));
            vocabularyRepository.saveAll(allByWord);

            return Result.error("数据库异常，部分数据未能更新！");
        } else {
            return  Result.error("数据库异常！");
        }

    }

}
