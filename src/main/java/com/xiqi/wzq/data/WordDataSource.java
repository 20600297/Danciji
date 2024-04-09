package com.xiqi.wzq.data;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONReader;
import com.xiqi.wzq.entity.word.Word;
import com.xiqi.wzq.enums.WordCategoryName;
import com.xiqi.wzq.repo.WordRepository;
import com.xiqi.wzq.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Component
public class WordDataSource {
    public static void init() {
        log.info("开始初始化数据！");
        getCET4();
    }

    public static void getCET4(){
        try {
            Path CET4_path = Paths.get("src/main/resources/static/CET4.txt");
            String CET4_str = Files.readString(CET4_path);
            JSONObject CET4_json = JSONObject.parseObject(CET4_str).getJSONObject("CET4");

            List<Word> words = CET4_json.getJSONArray("words").toJavaList(Word.class, JSONReader.Feature.SupportSmartMatch);

            words.forEach(e ->{
                e.setCategory(WordCategoryName.Cet4.getCategory());
            });

            WordRepository repository = SpringUtils.getBean(WordRepository.class);

            if (repository.findAll().isEmpty()) {
                repository.saveAll(words);
            }

            log.info("CET4 初始化完毕！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
