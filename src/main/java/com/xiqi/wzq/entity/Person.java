package com.xiqi.wzq.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xiqi.wzq.entity.word.Word;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long account;

    private String username;

    @JsonIgnore
    private String password;

    private String nickname;

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
        this.nickname = null;
    }

}
