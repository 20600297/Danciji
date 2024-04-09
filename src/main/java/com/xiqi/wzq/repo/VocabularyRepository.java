package com.xiqi.wzq.repo;

import com.xiqi.wzq.entity.Vocabulary;
import com.xiqi.wzq.entity.word.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VocabularyRepository extends JpaRepository<Vocabulary,Long>, JpaSpecificationExecutor<Vocabulary> {

    long countAllByStatus(Integer status);

    List<Vocabulary> findAllByCategory(String category);

    Vocabulary findByWordWordLike(String word_word);

    @Query("SELECT v FROM Vocabulary v WHERE v.word.word IN :words")
    List<Vocabulary> findAllByWord(@Param("words") List<String> words);
}
