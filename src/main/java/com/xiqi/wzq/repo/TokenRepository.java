package com.xiqi.wzq.repo;

import com.xiqi.wzq.entity.Token;
import com.xiqi.wzq.entity.word.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TokenRepository extends JpaRepository<Token,String> , JpaSpecificationExecutor<Word> {

    Token findByToken(String token);

    void deleteAllByUsername(String username);
}
